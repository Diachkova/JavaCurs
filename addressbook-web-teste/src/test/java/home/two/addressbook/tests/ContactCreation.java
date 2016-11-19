package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreation extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoContactList();
    int before = app.getContactHelper().getContactCount();
    System.out.println("before " + before);
    app.getContactHelper().createContact(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn",
            "Moscow Street House", "terra72@inbox.ru", null, null, "\\9", "\\9", "Test3"));
    int after = app.getContactHelper().getContactCount();
    System.out.println("after " + after);
    Assert.assertEquals(after, before + 1);
  }

}
