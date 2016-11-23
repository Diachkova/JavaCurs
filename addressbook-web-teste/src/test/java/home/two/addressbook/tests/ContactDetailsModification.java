package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactDetailsModification extends TestBase {
  //второй способ через кнопку details

  @BeforeMethod
  public void ensurePrconditions() {
    app.getNavigationHelper().gotoContactList();
    if (!app.getContactHelper().isThereAContact()) {
      System.out.println("нет контакта");
      app.getContactHelper().createContact(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn",
              "Moscow Street House", "terra72@inbox.ru", null, null, "\\9", "\\9", "Test3"));
    }
  }

  @Test
  public void testDetailsModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int indexC = before.size() - 1;
    int indexB = before.size() + 1;
    ContactData contact = new ContactData(before.get(indexC).getId(), "Marina", "Kirillovna", "Semenova", "Rena",
            "CNN", "5", "Sever", null, null, null, null, null, "Test3");
    app.getContactHelper().modifyDetailsContact(indexC, indexB, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(indexC);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }



}
