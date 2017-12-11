package basics;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class SearchForTests extends TestBase {


  @Test
    public void testSearchFor() {
    app.wd.findElement(By.xpath(".//*[@id='bq']")).click();
    //app.wd.sendKeys("Harry Potter");
    app.wd.findElement(By.xpath(".//*[@id='searchSet']/button")).click();


    }


}



















