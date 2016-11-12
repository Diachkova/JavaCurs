package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactList();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoPageContactCreation();
      app.getContactHelper().createContact(new ContactData("Marina", "Kirillovna", "Gorkina", "Fina", "BaseCamp", "4",
              "1", "1", "1","1", "2", "3", "Test3"));
      app.getNavigationHelper().gotoContactList();

    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoContactList();

  }

}
