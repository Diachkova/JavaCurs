package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDetailsModification extends TestBase {
  //второй способ через кнопку details

  @Test
  public void testDetailsModification() {
    app.getNavigationHelper().gotoContactList();

    if (! app.getContactHelper().isThereAContact()) {
      System.out.println("нет контакта");
      app.getNavigationHelper().gotoPageContactCreation();
      app.getContactHelper().createContact(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn",
              "Moscow Street House", "terra72@inbox.ru", null, null, "\\9", "\\9", "Test3"));
      app.getNavigationHelper().gotoContactList();
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().clickContactDetails();
    app.getContactHelper().clickContactModify();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Kirillovna", "Gorkina", "Fina", "BaseCamp", "4",
            "1", "1", "1","1", "2", "3", "Test3"), false);
    app.getContactHelper().clickContactUpdate();
    app.getNavigationHelper().gotoContactList();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }

}
