package home.two.addressbook.tests;


import home.two.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().allC().size() == 0) {
      System.out.println("нет контакта");
      app.contact().createContact(new ContactData().withName("Nadia").withMiddleName("Yurievna").
              withSurname("Diachkova").withNik("Nicki").withAddress("MyOwn").
              withHome("Moscow Street House").withEmail("terra72@inbox.ru").withGroup("Test1"));
    }
  }

  @Test
  public void testContactModification(){
    Set<ContactData> before = app.contact().allC();
    ContactData modifiedContact = before.iterator().next();
    //int indexB = before.size() + 1;
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Elena").
            withMiddleName("Ivanovna").withSurname("Petrova").withNik("Sena").withCompany("BBC").withAddress("7").
            withHome("South").withGroup("Test1");
    //System.out.println("selecting contact " + (modifiedContact.getId()));
    app.contact().modifyEdit(contact);
    Set<ContactData> after = app.contact().allC();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    System.out.println("before " + before);
    System.out.println("after " + after);
    Assert.assertEquals(before, after);

  }

}
