package home.two.addressbook.tests;

import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreation extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().allC();
    System.out.println("before " + before.size());
    File photo = new File("src/test/resourses/stru.png");
    ContactData contact = new ContactData().withName("Nadia").withMiddleName("Yurievna").
            withSurname("Diachkova").withAddress("MyOwn").
            withHome("111").withEmail("terra72@inbox.ru").withPhoto(photo);
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().allC();
    System.out.println("after " + after.size());
    assertThat(after, equalTo(
            before.withCAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
  }
}