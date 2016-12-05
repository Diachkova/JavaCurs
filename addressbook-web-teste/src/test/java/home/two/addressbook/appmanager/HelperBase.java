package home.two.addressbook.appmanager;

import org.openqa.selenium.*;

import java.io.File;
import java.util.List;

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

  protected void attach(By locator, File file) {
    if (isElementPresent(By.name("photo"))) {
      if (file != null) {
        getElement(locator).sendKeys(file.getAbsolutePath());
      }
    }else {
      throw new RuntimeException("file not found");
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


  protected List<WebElement> getListElements(By locator)
  {
    return wd.findElements(locator);
  }


  protected int getCount(By locator) {
    return wd.findElements(locator).size();
  }
}
