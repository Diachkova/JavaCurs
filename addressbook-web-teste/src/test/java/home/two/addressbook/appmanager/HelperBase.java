package home.two.addressbook.appmanager;

import org.openqa.selenium.*;

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
    if (text != null) {
      String existingText = getElement(locator).getAttribute("value");
        if (! text.equals(existingText)) {
          subject.clear();
          subject.sendKeys(text);
        }
    }
  }

  public void popUpClose() {
    boolean alert =  isAlertPresent();
    if (alert == true) {
      getAlert().accept();
    }
  }


  public boolean isAlertPresent() {
    try {
      getAlert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private Alert getAlert() {
    return wd.switchTo().alert();
  }
}
