package home.two.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Andrey on 31.10.2016.
 */
public class SessionHelper {
  public WebDriver wd;

  public SessionHelper(WebDriver wd) {
    this.wd = wd;
  }
  public void login(String username, String password) {
    wd.findElement(By.id("content")).click();
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
}
