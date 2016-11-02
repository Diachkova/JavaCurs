package home.two.addressbook.appmanager;

import home.two.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void contentContact() {
    click(By.xpath("//div[@id='content']/form/input[@value='Enter']"));
  }

  public void fillContactForm(ContactData contactData) {
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
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]//input[@value='Delete']"));
    popUpClose();

  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void clickContactEdit() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }

  public void clickContactUpdate() {
    click(By.xpath("//div[@id='content']/form[1]//input[@value='Update']"));
  }

  public void clickContactDetails() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));

  }

  public void clickContactModify() {
    click(By.name("modifiy"));

  }

}
