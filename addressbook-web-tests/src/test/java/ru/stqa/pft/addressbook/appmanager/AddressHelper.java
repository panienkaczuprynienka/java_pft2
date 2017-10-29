package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("address"), addressData.getPersonalAddress());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void editSelectedAddress(int index) {
    wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index+1).click();
  }

  public void editSelectedAddressById(int id) {
   // wd.findElements(By.cssSelector("a[href^='edit.php']")).get(id+1).click();
    //wd.findElements(By.cssSelector("tr[name=entry] a[href^='edit.php']")).get(id).click();
    wd.findElements(By.cssSelector("tr[name=entry] a[href='edit.php?id=" + id + "]")).get(id).click();
    //wd.findElements(By.xpath("//tr[@name='entry']//td[@class='center'][3]")).get(id).click();
  }

  public void selectAddress(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectAddressById(int id) {
      wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }



  public void submitAddressModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(AddressData address, boolean creation) {
    initAddressCreation();
    fillAddressForm(address, creation);
    submitAddressForm();
    returnToHomePage();
  }


  public void modify(AddressData address) {
    selectAddressById(address.getId());
    editSelectedAddressById(address.getId());
    fillAddressForm(address, false);
    submitAddressModification();
    returnToHomePage();
  }

  public void delete(int index) {
    selectAddress(index);
    deleteAddress();
    okAlert();
  }


  public void delete(AddressData address) {
    selectAddressById(address.getId());
    deleteAddress();
    okAlert();
  }

  public boolean isThereAnAddress() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getAddressCount() {
   return wd.findElements(By.name("selected[]")).size();
  }



  public void deleteAddress() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }



  public void okAlert() {
    wd.switchTo().alert().accept();
  }

  public List<AddressData> list() {
    List<AddressData> addresses = new ArrayList<AddressData>();
    List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
    for (WebElement element : elements){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      addresses.add(new AddressData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return addresses;
  }

  public Set<AddressData> all() {
    Set<AddressData> addresses = new HashSet<AddressData>();
    List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
    for (WebElement element : elements){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      addresses.add(new AddressData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return addresses;
  }


}

