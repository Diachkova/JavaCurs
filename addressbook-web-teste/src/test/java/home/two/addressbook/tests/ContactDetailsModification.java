package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Contacts before = app.contact().allC();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).withName("Marina").withMiddleName("Kirillovna").withSurname("Semenova").
            withNik("Rena").withCompany("CNN").withAddress("5").withHome("Sever").withGroup("Test3");
    app.contact().modifyDetails(contact);
    Contacts after = app.contact().allC();
    assertThat(after.size(), equalTo(before.size()));

    System.out.println("before " + before);
    System.out.println("after " + after);
    assertThat(after, equalTo(before.without(modifiedContact).withCAdded(contact)));

  }



}
