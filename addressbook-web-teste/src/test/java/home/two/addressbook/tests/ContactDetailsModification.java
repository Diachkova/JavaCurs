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
    app.goTo().contactPage();
    if (app.contact().list().size() == 0) {
      System.out.println("нет контакта");
      ContactData contact = new ContactData().withName("Nadia").withMiddleName("Yurievna").
              withSurname("Diachkova").withNik("Nicki").withAddress("MyOwn").
              withHome("Moscow Street House").withEmail("terra72@inbox.ru").withGroup("Test3");
    }
  }

  @Test
  public void testDetailsModification() {
    List<ContactData> before = app.contact().list();
    int indexC = before.size() - 1;
    int indexB = before.size() + 1;
    ContactData contact = new ContactData().
            withId(before.get(indexC).getId()).withName("Marina").withMiddleName("Kirillovna").withSurname("Semenova").
            withNik("Rena").withCompany("CNN").withAddress("5").withHome("Sever").withGroup("Test3");
    app.contact().modifyDetails(indexC, indexB, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(indexC);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }



}
