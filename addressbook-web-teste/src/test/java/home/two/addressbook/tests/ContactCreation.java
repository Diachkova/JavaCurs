package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreation extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().allC();
    ContactData contact = new ContactData().withName("Nadia").withMiddleName("Yurievna").
            withSurname("Diachkova").withNik("Nicki").withAddress("MyOwn").
            withHome("Moscow Street House").withEmail("terra72@inbox.ru").withGroup("Test3");
    app.contact().createContact(contact);
    System.out.println("before " + before);
    Set<ContactData> after = app.contact().allC();
    System.out.println("after " + after);

    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
