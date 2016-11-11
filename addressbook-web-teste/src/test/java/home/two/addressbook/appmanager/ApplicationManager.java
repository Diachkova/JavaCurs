package home.two.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
  public WebDriver wd;

  private ContactHelper contactHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    //System.setProperty("webdriver.chrome.driver", "C:\\Nadia\\driver\\chromedriver_win32\\chromedriver.exe");
    //System.setProperty("webdriver.gecko.driver", "C:\\Nadia\\driver\\geckodriver-v0.11.1-win64\\geckodriver.exe");
    //System.setProperty("webdriver.ie.driver", "C:\\Nadia\\driver\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
    //System.setProperty("webdriver.opera.driver", "C:\\Nadia\\driver\\operadriver_win32\\operadriver.exe");


    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if  (Objects.equals(browser, BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      wd = new ChromeDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
