package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.AddressData;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {


  public final ApplicationManager app = new ApplicationManager();
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  protected void login(String username, String password) {
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

  protected void goToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  protected void submitAddressForm() {
    wd.findElement(By.name("submit")).click();
  }

  protected void fillAddressForm(AddressData addressData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(addressData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(addressData.getLastname());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(addressData.getAddress());
  }

  protected void goToAddressPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod
  public void tearDown() {

    app.stop();
  }

  protected void deleteSelectedAddress() {
      wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
  }

  protected void editSelectedAddress() {
      wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
  }
}
