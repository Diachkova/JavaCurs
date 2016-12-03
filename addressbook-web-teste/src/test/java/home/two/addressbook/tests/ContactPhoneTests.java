package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Andrey on 03.12.2016.
 */
public class ContactPhoneTests extends TestBase {

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
  public void testContactPhones() {
    app.goTo().contactPage();
    ContactData contact = app.contact().allC().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
  }
}
