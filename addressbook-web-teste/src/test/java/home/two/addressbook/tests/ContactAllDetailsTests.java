package home.two.addressbook.tests;
        import home.two.addressbook.model.ContactData;
        import org.testng.annotations.Test;
        import org.testng.annotations.BeforeMethod;

        import java.lang.reflect.Array;
        import java.util.Arrays;
        import java.util.stream.Collectors;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.core.IsEqual.equalTo;


public class ContactAllDetailsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().allC().size() == 0) {
      System.out.println("нет контакта");
      app.contact().createContact(new ContactData().withName("Nadia").
              withSurname("Diachkova").withHome("333").withEmail("terra72@inbox.ru"));
    }
  }

  @Test
  public void testAllDetails() {
    ContactData contact = app.contact().allC().iterator().next();
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
    ContactData contactEditDetailsForm = app.contact().infoEditDetailsForm(contact);

    //assertThat(contactInfoFromDetailsForm.getAllData(), equalTo(mergeEditData(contactEditDetailsForm)));
    assertThat(mergeDetailsData(contactInfoFromDetailsForm), equalTo(mergeEditData(contactEditDetailsForm)));

  }

  private String mergeEditData(ContactData contact) {
    System.out.println("getAddress " + contact.getAddress());
    return Arrays.asList(contact.getAllName(),  contact.getAddress(), contact.getHome(),
            contact.getMobile(), contact.getWork(), contact.getEmail(), contact.getEmail2(), contact.getEmail3()).
            stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n")).replaceAll("\\s", "");

  }
//map(ContactAllDetailsTests::cleanedEditData)
  private String mergeDetailsData(ContactData contact) {
    return Arrays.asList(contact.getAllData()).
            stream().filter((s) -> !s.equals("")).map(ContactAllDetailsTests::cleanedDetData).
            collect(Collectors.joining("\n")).replaceAll("\n\n","\n").replaceAll("\\s", "");

  }


  public static String cleanedDetData(String details) {
    return details.replaceAll("[H: ,M: ,W: ]", "");
  }

}
