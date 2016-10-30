package home.two.addressbook;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class ContactCreation {
    ChromeDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Nadia\\driver\\chromedriver_win32\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void ContactCreation() {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
        wd.findElement(By.linkText("add new")).click();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("Nadia");
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys("Yurievna");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("Diachkova");
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys("Nicki");
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).sendKeys("\\9");
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys("MyOwn");
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys("Moscow Street House");
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).sendKeys("\\9");
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).sendKeys("\\9");
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).sendKeys("\\9");
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).sendKeys("\\9");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("terra72@inbox.ru");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
    }
    
    @AfterMethod
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
