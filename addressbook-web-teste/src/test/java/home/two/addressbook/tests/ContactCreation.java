package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreation extends TestBase {

  @Test
  public void testContactCreation() {
    app.gotoPageContactCreation();
    app.fillContactForm(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn", "Moscow Street House",
            "terra72@inbox.ru", "\\9", "\\9", "\\9", "\\9"));
    app.contentContact();
    app.returnToContactsPage();
  }

}
