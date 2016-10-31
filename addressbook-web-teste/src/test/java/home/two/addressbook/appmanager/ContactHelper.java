package home.two.addressbook.appmanager;

import home.two.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper {
  public WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void returnToContactsPage() {
    wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
  }

  public void contentContact() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    typeCont(By.name("firstname"), contactData.getName());
    typeCont(By.name("middlename"), contactData.getMiddleName());
    typeCont(By.name("lastname"), contactData.getSurname());
    typeCont(By.name("nickname"), contactData.getNik());
    typeEmpty(By.name("title"), contactData.getTitle());
    typeCont(By.name("company"), contactData.getCompany());
    typeCont(By.name("address"), contactData.getAddress());
    typeEmpty(By.name("home"), contactData.getHome());
    typeEmpty(By.name("mobile"), contactData.getMobile());
    typeEmpty(By.name("work"), contactData.getWork());
    typeEmpty(By.name("fax"), contactData.getFax());
    typeCont(By.name("email"), contactData.getEmail());
  }

  private void typeEmpty(By title, String textTitle) {
    wd.findElement(title).click();
    wd.findElement(title).sendKeys(textTitle);
  }

  private void typeCont(By firstname, String textName) {
    wd.findElement(firstname).click();
    wd.findElement(firstname).clear();
    wd.findElement(firstname).sendKeys(textName);
  }

  public void deleteContact() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }
}
