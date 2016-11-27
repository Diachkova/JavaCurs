package home.two.addressbook.tests;


import home.two.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePrconditions() {
    app.goTo().contactPage();
    if (app.contact().list().size() == 0) {
      System.out.println("нет контакта");
      app.contact().createContact(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn",
              "Moscow Street House", "terra72@inbox.ru", null, null, "\\9", "\\9", "Test3"));
    }
  }

  @Test
  public void testContactModification(){
    List<ContactData> before = app.contact().list();
    int indexC = before.size() - 1;
    int indexB = before.size() + 1;
    ContactData contact = new ContactData(before.get(indexC).getId(), "Elena", "Ivanovna", "Petrova", "Sena",
            "CNN", "5", "Sever", null, null, null, null, null, "Test3");

    System.out.println("selecting contact " + (indexC));
    app.contact().modifyEdit(contact, indexC, indexB);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(indexC);
    before.add(contact);

    System.out.println("before " + before);
    System.out.println("after " + after);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }



}
