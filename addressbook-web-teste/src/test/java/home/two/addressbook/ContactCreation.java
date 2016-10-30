package home.two.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreation extends TestBase {

  @Test
  public void testContactCreation() {
    gotoPageContactCreation();
    fillContactForm(new ContactData("Nadia", "Yurievna", "Diachkova", "Nicki", "\\9", "MyOwn", "Moscow Street House",
            "terra72@inbox.ru", "\\9", "\\9", "\\9", "\\9"));
    contentContact();
    returnToContactsPage();
  }

}
