package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactDetailsModification extends TestBase {
  //второй способ через кнопку details

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().allC().size() == 0) {
      System.out.println("нет контакта");
      app.contact().createContact(new ContactData().withName("Nadia").withMiddleName("Yurievna").
              withSurname("Diachkova").withNik("Nicki").withAddress("MyOwn").
              withHome("Moscow Street House").withEmail("terra72@inbox.ru").withGroup("Test3"));
    }
  }

  @Test
  public void testDetailsModification() {
    Set<ContactData> before = app.contact().allC();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).withName("Marina").withMiddleName("Kirillovna").withSurname("Semenova").
            withNik("Rena").withCompany("CNN").withAddress("5").withHome("Sever").withGroup("Test3");
    app.contact().modifyDetails(contact);
    Set<ContactData> after = app.contact().allC();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }



}
