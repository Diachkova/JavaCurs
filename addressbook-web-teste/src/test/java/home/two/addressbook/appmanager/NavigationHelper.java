package home.two.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Andrey on 31.10.2016.
 */
public class NavigationHelper extends HelperBase{


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoPageContactCreation() {
    click(By.linkText("add new"));
  }

  public void gotoContactList() {
    click(By.linkText("home"));
  }
}
