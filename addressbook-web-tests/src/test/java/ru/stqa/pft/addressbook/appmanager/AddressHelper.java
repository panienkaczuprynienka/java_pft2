package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressHelper extends HelperBase{

  public AddressHelper(FirefoxDriver wd) {

    super(wd);
  }

  public void goToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitAddressForm() {
    click(By.name("submit"));
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillAddressForm(AddressData addressData) {
    type(By.name("firstname"), addressData.getFirstname());
    type(By.name("lastname"), addressData.getLastname());
    type(By.name("address"), addressData.getAddress());
  }

  protected void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void deleteSelectedAddress() {

    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void editSelectedAddress() {
    click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
  }
}
