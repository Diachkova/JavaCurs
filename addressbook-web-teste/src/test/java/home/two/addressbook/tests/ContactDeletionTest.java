package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.Assert;
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
    int before = app.getContactHelper().getContactCount();
    System.out.println("before " + before);
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoContactList();
    int after = app.getContactHelper().getContactCount();
    System.out.println("after " + after);
    Assert.assertEquals(after, before - 1);

  }

}
