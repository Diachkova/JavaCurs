package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDetailsModification extends TestBase {
  //второй способ через кнопку details

  @Test
  public void testDetailsModification() {
    app.getNavigationHelper().gotoContactList();
    app.getContactHelper().clickContactDetails();
    app.getContactHelper().clickContactModify();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Kirillovna", "Gorkina", "Fina", "BaseCamp", "4",
            null, null, null, null, null, null));
    app.getContactHelper().clickContactUpdate();
    app.getNavigationHelper().gotoContactList();
  }

}
