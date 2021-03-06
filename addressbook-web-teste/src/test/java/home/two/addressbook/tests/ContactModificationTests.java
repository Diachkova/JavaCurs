package home.two.addressbook.tests;


import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().allC().size() == 0) {
      System.out.println("нет контакта");
      app.contact().createContact(new ContactData().withName("Nadia").withMiddleName("Yurievna").
              withSurname("Diachkova").withNik("Nicki").withAddress("MyOwn").
              withHome("555").withEmail("terra72@inbox.ru").withGroup("Test1"));
    }

    System.out.println("before contacts count = " + app.contact().count());
  }

  @Test
  public void testContactModification(){
    Contacts before = app.contact().allC();
    ContactData modifiedContact = before.iterator().next();
    //int indexB = before.size() + 1;
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Elena").
            withMiddleName("Ivanovna").withSurname("Petrova").withNik("Sena").withCompany("BBC").withAddress("7").
            withHome("111").withGroup("Test1");
    //System.out.println("selecting contact " + (modifiedContact.getId()));
    app.contact().modifyEdit(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().allC();

    System.out.println("before " + before);
    System.out.println("after " + after);
    assertThat(after, equalTo(before.without(modifiedContact).withCAdded(contact)));

  }

}
