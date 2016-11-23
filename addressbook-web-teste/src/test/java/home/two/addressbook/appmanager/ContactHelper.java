package home.two.addressbook.appmanager;

import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
  private ApplicationManager app;

  public ContactHelper(WebDriver wd, ApplicationManager app) {
    super(wd);
    this.app = app;
  }



  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("nickname"), contactData.getNik());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(getElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void contentContact() {
    click(By.xpath("//div[@id='content']/form/input[@value='Enter']"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]//input[@value='Delete']"));
    popUpClose();
    app.getNavigationHelper().gotoContactList();

  }

  public void selectContact(int indexc) {
    getListElements(By.name("selected[]")).get(indexc).click();

  }

  public void clickContactEdit(int index) {
    if (isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[" + index + "]/td[8]/a/img"))) {
      click(By.xpath("//table[@id='maintable']/tbody/tr[" + index + "]/td[8]/a/img"));

    } else {
      throw new RuntimeException("Edit button not found");

    }
  }

  public void clickContactUpdate() {
    if (isElementPresent(By.xpath("//div[@id='content']/form[1]//input[@value='Update']"))) {
      click(By.xpath("//div[@id='content']/form[1]//input[@value='Update']"));

    } else {
      throw new RuntimeException("Update button not found");
    }
  }

  public void clickContactDetails(int index) {
    if (isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[" + index + "]/td[7]/a/img"))) {
      click(By.xpath("//table[@id='maintable']/tbody/tr[" + index + "]/td[7]/a/img"));
    } else {
      throw new RuntimeException("Details button not found");
    }
  }

  public void modifyDetailsContact(int indexC, int indexB, ContactData contact) {
    selectContact(indexC);
    clickContactDetails(indexB);
    clickContactModify();
    fillContactForm(contact, false);
    clickContactUpdate();
    app.getNavigationHelper().gotoContactList();
  }

  public void modifyEditContact(ContactData contact, int indexC, int indexB) {
    selectContact(indexC);
    clickContactEdit(indexB);
    fillContactForm(contact, false);
    clickContactUpdate();
    app.getNavigationHelper().gotoContactList();
  }

  public void clickContactModify() {
    if (isElementPresent(By.name("modifiy"))) {
      click(By.name("modifiy"));
    } else {
      throw new RuntimeException("Modify button not found");
    }
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData cdata)  {
    app.getNavigationHelper().gotoPageContactCreation();
    fillContactForm(cdata, true);
    contentContact();
    app.getNavigationHelper().gotoContactList();
  }

  public int getContactCount() {
    return getCount(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = getListElements(By.xpath("//tr[@name='entry']"));
    System.out.println("elements list size = " + elements.size());
    for (WebElement element : elements) {
      try {
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        String surname = element.findElements(By.tagName("td")).get(1).getText();
        String name = element.findElements(By.tagName("td")).get(2).getText();
        System.out.println("got contact id=" + id + ", name = " + name + ", surname = " + surname);
        ContactData contact = new ContactData(id, name, null, surname, null, null, null, null, null, null, null, null,
                null, null);
        contacts.add(contact);
      } catch (NoSuchElementException e) {
        // do nothing
      }
    }
    return contacts;
  }
}



