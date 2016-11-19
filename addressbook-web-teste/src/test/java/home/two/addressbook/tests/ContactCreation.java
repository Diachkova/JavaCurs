package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreation extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoContactList();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn",
            "Moscow Street House", "terra72@inbox.ru", null, null, "\\9", "\\9", "Test3");
    app.getContactHelper().createContact(contact);
    System.out.println("before " + before);
    List<ContactData> after = app.getContactHelper().getContactList();
    System.out.println("after " + after);

    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
