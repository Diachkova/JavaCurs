package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreation extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().contactPage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withName("Nadia").withMiddleName("Yurievna").
            withSurname("Diachkova").withNik("Nicki").withAddress("MyOwn").
            withHome("Moscow Street House").withEmail("terra72@inbox.ru").withGroup("Test3");
    app.contact().createContact(contact);
    System.out.println("before " + before);
    List<ContactData> after = app.contact().list();
    System.out.println("after " + after);

    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
