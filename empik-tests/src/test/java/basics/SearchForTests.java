package basics;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class SearchForTests extends TestBase {


  @BeforeMethod
  public void setUp() throws Exception {
    app.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    app.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    app.logIn("OlimpiaZak@vp.pl", "Olimpia1");

  }




  @Test
    public void testSearchFor() {
    app.wd.findElement(By.xpath(".//*[@id='bq']")).click();
    //app.wd.sendKeys("Harry Potter");
    app.wd.findElement(By.xpath(".//*[@id='searchSet']/button")).click();


    }


  @AfterMethod
  public void tearDown() {
    app.wd.quit();
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



















