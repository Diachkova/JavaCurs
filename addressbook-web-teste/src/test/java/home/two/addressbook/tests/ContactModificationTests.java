package home.two.addressbook.tests;


import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;


public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactList();
    if (! app.getContactHelper().isThereAContact()) {
      System.out.println("нет контакта");
      app.getContactHelper().createContact(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn",
              "Moscow Street House", "terra72@inbox.ru", null, null, "\\9", "\\9", "Test3"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    System.out.println("selecting contact " + (before.size() - 1));
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().clickContactEdit(before.size() + 1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "Elena", "Ivanovna", "Petrova", "Sena",
            "CNN", "5", "Sever", null, null, null, null, null, "Test3");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().clickContactUpdate();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);

    System.out.println("before " + before);
    System.out.println("after " + after);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


  }


}
