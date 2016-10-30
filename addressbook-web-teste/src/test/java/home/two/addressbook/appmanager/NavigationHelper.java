package home.two.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Andrey on 31.10.2016.
 */
public class NavigationHelper {
  public WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoPageContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }
}
