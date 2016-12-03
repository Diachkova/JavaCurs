package home.two.addressbook.appmanager;

import home.two.addressbook.model.ContactData;
import home.two.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
  }
  

  public void selectContactById(int id) {
    //getElement(By.xpath("//input[@value='"+id+"']")).click();
    getElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void clickContactEdit(int id) {
    getElement(By.xpath("//a[@href='edit.php?id="+id+"']")).click();
  }


  public void clickContactUpdate() {
    if (isElementPresent(By.xpath("//div[@id='content']/form[1]//input[@value='Update']"))) {
      click(By.xpath("//div[@id='content']/form[1]//input[@value='Update']"));

    } else {
      throw new RuntimeException("Update button not found");
    }
  }

  public void clickContactDetails(int id) {
    if (isElementPresent(By.xpath("//a[@href='view.php?id="+id+"']"))) {
      getElement(By.xpath("//a[@href='view.php?id="+id+"']")).click();
    } else {
      throw new RuntimeException("Details button not found");
    }
  }

  public void modifyDetails(ContactData contact) {
    selectContactById(contact.getId());
    clickContactDetails(contact.getId());
    clickContactModify();
    fillContactForm(contact, false);
    clickContactUpdate();
    contactCache = null;
    app.goTo().contactPage();
  }

  public void modifyEdit(ContactData contact) {
    selectContactById(contact.getId());
    clickContactEdit(contact.getId());
    fillContactForm(contact, false);
    clickContactUpdate();
    contactCache = null;
    app.goTo().contactPage();
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
    app.goTo().gotoPageContactCreation();
    fillContactForm(cdata, true);
    contentContact();
    contactCache = null;
    app.goTo().contactPage();
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    contactCache = null;
    app.goTo().contactPage();

  }

  public int count() {
    return getCount(By.name("selected[]"));
  }

  private Contacts contactCache = null;


  public Contacts allC() {
      if (contactCache !=null) {
        return new Contacts(contactCache);
      }

    contactCache = new Contacts();
    List<WebElement> elements = getListElements(By.xpath("//tr[@name='entry']"));
    System.out.println("elements list size = " + elements.size());
    for (WebElement element : elements) {
      //try {
        String surname = element.findElements(By.tagName("td")).get(1).getText();
        String name = element.findElements(By.tagName("td")).get(2).getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        System.out.println("got contact id=" + id + ", name = " + name + ", surname = " + surname);
        System.out.println("trying to get phones from " + element.findElements(By.tagName("td")).get(5).getText());
        String allPhones = element.findElements(By.tagName("td")).get(5).getText();
        contactCache.add(new ContactData().withId(id)
                .withName(name).withSurname(surname).withAllPhones(allPhones));
      //} catch (NoSuchElementException e) {
        // do nothing
      //}
    }
    return new Contacts(contactCache);
  }


  public ContactData infoFromEditForm(ContactData contact) {
  initContactModificatonById(contact.getId());
  String surname = getElement(By.name("lastname")).getAttribute("value");
  String firstname = getElement(By.name("firstname")).getAttribute("value");
  String home = getElement(By.name("home")).getAttribute("value");
  String mobile = getElement(By.name("mobile")).getAttribute("value");
  String work = getElement(By.name("work")).getAttribute("value");
  wd.navigate().back();
  return  new ContactData().withId(contact.getId()).withSurname(surname).withName(firstname).
          withMobile(mobile).withHome(home).withWork(work);
  }

  private void initContactModificatonById(int id) {
    getElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }


}




