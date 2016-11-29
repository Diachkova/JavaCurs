package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreation extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().allC();
    System.out.println("before " + before.size());
    ContactData contact = new ContactData().withName("Nadia").withMiddleName("Yurievna").
            withSurname("Diachkova").withNik("Nicki").withAddress("MyOwn").
            withHome("Moscow Street House").withEmail("terra72@inbox.ru").withGroup("Test3");
    app.contact().createContact(contact);
    Contacts after = app.contact().allC();
    System.out.println("after " + after.size());

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withCAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}