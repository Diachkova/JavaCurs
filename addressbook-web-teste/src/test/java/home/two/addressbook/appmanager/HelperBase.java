package home.two.addressbook.appmanager;

import org.openqa.selenium.*;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    getElement(locator).click();
  }

  protected WebElement getElement(By locator) {
    return wd.findElement(locator);
  }

  public boolean isElementPresent(By locator) {
    try {
      getElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }


  protected void type(By locator, String text) {
    WebElement subject = getElement(locator);
    if (text != null) {
      String existingText = subject.getAttribute("value");
        if (! text.equals(existingText)) {
          subject.clear();
          subject.sendKeys(text);
        }
    }
  }



  public void popUpClose() {
    if (isAlertPresent()) {
      wd.switchTo().alert().accept();
    } else {
      throw new RuntimeException ("не появилось окно");
    }
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
