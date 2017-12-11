package basics;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;


  private String browser;


  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();

  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


      if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
      } else if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }

    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));

    wd.get("http://www.empik.com/");
    logIn("OlimpiaZak@vp.pl", "Olimpia1");

    }

  public void logIn(String username, String password) {
    wd.findElement(By.id("simple-dropdown2")).click();
    wd.findElement(By.name("j_username")).click();
    wd.findElement(By.name("j_username")).clear();
    wd.findElement(By.name("j_username")).sendKeys(username);
    wd.findElement(By.id("loginPassword")).click();
    wd.findElement(By.id("loginPassword")).clear();
    wd.findElement(By.id("loginPassword")).sendKeys(password);
    wd.findElement(By.xpath("//div[@class='loginRegisterForm']//button[.='Zaloguj się']")).click();
    assertTrue(isTextPresent("Witaj, " + username));

  }

  protected boolean isTextPresent(String text){
    try{
      boolean b = wd.getPageSource().contains(text);
      return b;
    }
    catch(Exception e){
      return false;
    }
  }


  public void stop() {

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
