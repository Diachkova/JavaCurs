package home.two.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;


public class ApplicationManager {
  public WebDriver wd;

  private ContactHelper contactHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;


  public void init() {
    //System.setProperty("webdriver.chrome.driver", "C:\\Nadia\\driver\\chromedriver_win32\\chromedriver.exe");
    //System.setProperty("webdriver.firefox.driver", "C:\\Nadia\\driver\\geckodriver-v0.9.0-win64\\geckodriver.exe");
    System.setProperty("webdriver.internetexplorer.driver", "C:\\Nadia\\driver\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
    String browser = CHROME;
    if (browser == BrowserType.FIREFOX) {
      wd = new FirefoxDriver();
    } else if  (browser == BrowserType.IE) {
      wd = new InternetExplorerDriver();
    } if (browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    }
    wd.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper = new SessionHelper(wd);
    wd.get("http://localhost/addressbook/");
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
