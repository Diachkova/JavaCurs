package home.two.addressbook.appmanager;

import home.two.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void contentContact() {
    click(By.xpath("//div[@id='content']/form/input[@value='Enter']"));
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

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]//input[@value='Delete']"));
    popUpClose();

  }

  public void selectContact() {
     click(By.name("selected[]"));

  }

  public void clickContactEdit() {
    if (isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"))) {
      click (By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
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

  public void clickContactDetails() {
    if (isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"))) {
      click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
    } else {
      throw new RuntimeException("Details button not found");
    }
  }

  public void clickContactModify() {
    if (isElementPresent(By.name("modifiy"))) {
     click (By.name("modifiy"));
   } else {
    throw new RuntimeException("Modify button not found");
  }
  }

}



