package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactDeletionTest extends TestBase {
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
  public void testContactDeletion() {
    Contacts before = app.contact().allC();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), CoreMatchers.equalTo(before.size()-1));
    Contacts after = app.contact().allC();
    assertThat(after, equalTo(before.without(deletedContact)));

  }

}
