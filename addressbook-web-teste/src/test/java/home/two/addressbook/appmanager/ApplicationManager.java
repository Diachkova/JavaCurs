package home.two.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
  private final Properties properties;
  public WebDriver wd;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private String browser;
  private ContactHelper contactHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();

  }

  public void init() throws IOException {
    //System.setProperty("webdriver.chrome.driver", "C:\\Nadia\\driver\\chromedriver_win32\\chromedriver.exe");
    //System.setProperty("webdriver.gecko.driver", "C:\\Nadia\\driver\\geckodriver-v0.11.1-win64\\geckodriver.exe");
    //System.setProperty("webdriver.ie.driver", "C:\\Nadia\\driver\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
    //System.setProperty("webdriver.opera.driver", "C:\\Nadia\\driver\\operadriver_win32\\operadriver.exe");
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if  (Objects.equals(browser, BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      wd = new ChromeDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    System.out.println(properties);
    groupHelper = new GroupHelper(wd, this);
    contactHelper = new ContactHelper(wd, this);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
