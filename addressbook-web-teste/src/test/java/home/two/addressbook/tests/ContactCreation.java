package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreation extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoPageContactCreation();
    app.getContactHelper().createContact(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn",
            "Moscow Street House", "terra72@inbox.ru", null, null, "\\9", "\\9", "Test3"));
    app.getNavigationHelper().gotoContactList();
  }

}
