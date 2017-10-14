package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressHelper extends HelperBase {

  public AddressHelper(WebDriver wd) {

    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitAddressForm() {
    click(By.name("submit"));
  }

  public void initAddressCreation() {

    click(By.linkText("add new"));
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillAddressForm(AddressData addressData, boolean creation) {
    type(By.name("firstname"), addressData.getFirstname());
    type(By.name("lastname"), addressData.getLastname());
    type(By.name("address"), addressData.getAddress());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));

    }
  }


  public void deleteSelectedAddress() {

    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void editSelectedAddress() {
    click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
  }

  public void submitAddressModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }
}
