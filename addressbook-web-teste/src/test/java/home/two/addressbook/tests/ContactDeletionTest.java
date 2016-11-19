package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactList();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Marina", "Kirillovna", "Gorkina", "Fina", "BaseCamp", "4",
              "1", "1", "1","1", "2", "3", "Test3"));

    }
    List<ContactData> before = app.getContactHelper().getContactList();
    System.out.println("before size = " + before.size());
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);

  }

}
