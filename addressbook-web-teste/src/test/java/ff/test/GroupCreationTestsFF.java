package ff.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTestsFF {
  FirefoxDriver wd;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\Nadia\\driver\\geckodriver-v0.11.1-win64\\geckodriver.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    login1("admin", "secret");
  }

   private void login1(String username, String login) {
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(login);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void testGroupCreation2() {
    gotoGroupPage();
    createNewGroup();
    fillGroupForm(new GroupDataFF("Test1", "Test2", "Test3"));
    submitForm();
    backTogroup();
  }

  private void backTogroup() {
    wd.findElement(By.linkText("group page")).click();
  }

  private void submitForm() {
    wd.findElement(By.name("submit")).click();
  }

  private void fillGroupForm(GroupDataFF groupDataFF ) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupDataFF.getGroupName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupDataFF.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupDataFF.getFooter());
  }

  private void createNewGroup() {
    wd.findElement(By.name("new")).click();
  }

  private void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  @After
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
