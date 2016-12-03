package home.two.addressbook.tests;
import home.two.addressbook.model.ContactData;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Andrey on 03.12.2016.
 */
public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().allC().size() == 0) {
      System.out.println("нет контакта");
      app.contact().createContact(new ContactData().withName("Nadia").withMiddleName("Yurievna").
              withSurname("Diachkova").withNik("Nicki").withAddress("MyOwn").
              withHome("333").withEmail("terra72@inbox.ru").withGroup("Test3"));
    }
  }

  @Test
  public void testContactAdress() {
    ContactData contact = app.contact().allC().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    //assertThat(contact.getAllAddress(), equalTo(ddress(contactInfoFromEditForm)));
  }

  //private String  mergeAddress(ContactData contact) {
//    return Arrays.asList(contact.getAddress().stream().filter((s) -> ! s.equals("")).
  //          map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
 // }

 // public static String cleaned(String address) {
  //  return address.replaceAll("\\s","").replaceAll("[-()]","");
  //}
}


