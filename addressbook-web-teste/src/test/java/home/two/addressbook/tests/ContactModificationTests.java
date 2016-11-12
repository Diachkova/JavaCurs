package home.two.addressbook.tests;


import home.two.addressbook.model.ContactData;
import org.testng.annotations.Test;



public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoContactList();
    if (! app.getContactHelper().isThereAContact()) {
      System.out.println("нет контакта");
      app.getNavigationHelper().gotoPageContactCreation();
      app.getContactHelper().createContact(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn",
              "Moscow Street House", "terra72@inbox.ru", null, null, "\\9", "\\9", "Test3"));
      app.getNavigationHelper().gotoContactList();
    }
    app.getContactHelper().clickContactEdit();
    app.getContactHelper().fillContactForm(new ContactData("Elena", "Ivanovna", "Petrova", "Sena", "CNN", "5", "Sever",
            null, null, null, null, null, "Test3"), false);
    app.getContactHelper().clickContactUpdate();
    app.getNavigationHelper().gotoContactList();

  }

}
