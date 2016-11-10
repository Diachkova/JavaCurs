package home.two.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
  private WebDriver wd;

  HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    getElement(locator).click();
  }

  protected WebElement getElement(By locator) {
    return wd.findElement(locator);
  }


  protected void type(By locator, String text) {
    WebElement subject = getElement(locator);
    subject.clear();
    subject.sendKeys(text);
  }

  public void popUpClose() {
    wd.switchTo().alert().accept();
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
