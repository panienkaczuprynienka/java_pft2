package basics;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {


  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));




  @BeforeMethod
  public void setUp() throws Exception {
    app.init();

  }



  @AfterMethod
  public void tearDown() {
    app.stop();
  }


}
