package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;


  private SessionHelper sessionHelper;
  private  NavigationHelper navigationHelper;
  private  GroupHelper groupHelper;
  private AddressHelper addressHelper;

   public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/addressbook/");
    groupHelper = new GroupHelper(wd);
    addressHelper = new AddressHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {

    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public void login(String username, String password) {
   wd.findElement(By.name("pass")).click();
   wd.findElement(By.name("pass")).sendKeys("\\undefined");
   wd.findElement(By.name("user")).click();
   wd.findElement(By.name("user")).clear();
   wd.findElement(By.name("user")).sendKeys();
   wd.findElement(By.name("pass")).click();
   wd.findElement(By.name("pass")).clear();
   wd.findElement(By.name("pass")).sendKeys();
   wd.findElement(By.name("user")).click();
   wd.findElement(By.name("user")).clear();
   wd.findElement(By.name("user")).sendKeys(username);
   wd.findElement(By.id("LoginForm")).click();
   wd.findElement(By.name("pass")).click();
   wd.findElement(By.name("pass")).clear();
   wd.findElement(By.name("pass")).sendKeys(password);
   wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public AddressHelper getAddressHelper() {
    return addressHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void goToAddressPage() {
    navigationHelper.goToAddressPage();
  }
}
