package home.two.addressbook.tests;


import home.two.addressbook.model.ContactData;
import org.testng.annotations.Test;


/**
 * Created by ndya on 02.11.2016.
 */
public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactList();
    app.getContactHelper().clickContactEdit();
    app.getContactHelper().fillContactForm(new ContactData("Elena", "Ivanovna", "Petrova", "Sena", "CNN", "5", "Sever",
            "1", "1", "1", "1", "1"));
    app.getContactHelper().clickContactUpdate();
    app.getNavigationHelper().gotoContactList();

  }

}
