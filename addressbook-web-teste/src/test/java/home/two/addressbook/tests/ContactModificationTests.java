package home.two.addressbook.tests;


import home.two.addressbook.model.ContactData;
import org.testng.annotations.Test;



public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactList();
    app.getContactHelper().clickContactEdit();
    app.getContactHelper().fillContactForm(new ContactData("Elena", "Ivanovna", "Petrova", "Sena", "CNN", "5", "Sever",
            null, null, null, null, null, "Test3"));
    System.out.println("line 1");
    app.getContactHelper().clickContactUpdate();
    app.getNavigationHelper().gotoContactList();

  }

}
