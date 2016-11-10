package home.two.addressbook.appmanager;

import org.openqa.selenium.*;

public class HelperBase {
  private WebDriver wd;

  public HelperBase(WebDriver wd) {
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
    if (text != null) {
      String existingText = subject.getAttribute("value");
        if (! text.equals(existingText)) {
          subject.clear();
          subject.sendKeys(text);
        }
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      getElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
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
