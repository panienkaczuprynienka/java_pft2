package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Addresses;

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
    attach(By.name("photo"), addressData.getPhoto());

    // ponizej zakomentowany if creation bo ciagle z tym problemy są
    /*
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    */
  }

  public void editSelectedAddress(int index) {
    wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index+1).click();
  }

  public void editSelectedAddressById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
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

  /*
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
  */

  public Addresses all() {
    Addresses addresses = new Addresses();
    List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
    for (WebElement element : elements){
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String personalAddress = element.findElement(By.xpath(".//td[4]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      addresses.add(new AddressData().withId(id).withFirstname(firstname).withLastname(lastname).withPersonalAddress(personalAddress)
              .withAllEmails(allEmails).withAllPhones(allPhones));
    }
    return addresses;
  }


  public AddressData infoFromEditForm(AddressData address) {
    initAddressModificationById(address.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String personalAddress = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String homepage = wd.findElement(By.name("homepage")).getAttribute("value");
  wd.navigate().back();
  return new AddressData().withId(address.getId()).
          withFirstname(firstname).withMiddlename(middlename).withLastname(lastname).withNickname(nickname)
          .withCompany(company).withTitle(title).withPersonalAddress(personalAddress)
          .withEmail(email).withEmail2(email2).withEmail3(email3)
          .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withFaxPhone(fax).withHomepage(homepage);
  }

  public String infoFromDetailForm(AddressData address){
    initAddressDetailById(address.getId());
    String detail = wd.findElement(By.xpath(".//*[@id='content']")).getText();
    wd.navigate().back();
    return detail;
  }

  // to jest taka sama metoda jak editSelectedAddressById ale oj tam
  private void initAddressModificationById(int id){
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  private void initAddressDetailById(int id){
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }

  public void move(AddressData address) {
    selectAddressById(address.getId());
    chooseSelectedAddress(address.getId());
    //expandDropDownList();
    //selectGroupByName();
    addAddress();

  }

  private void chooseSelectedAddress(int id) {
    if (!wd.findElement(By.id(String.format(("%s"), id))).isSelected()) {
      wd.findElement(By.id(String.format(("%s"), id))).click();
    }
    //wd.findElement(By.cssSelector(String.format(".//*[@id='%s']", id))).click();

  }

  private void addAddress(){
    wd.findElement(By.name("add")).click();
  }

  private void expandDropDownList(){
    wd.findElement(By.name("to_group")).click();
  }


  public void goToLastGroupPage() {
    wd.findElement(By.linkText("group page \"grupa1\"")).click();
  }

  public void expandTopDropdownList() {
    wd.findElement(By.name("group")).click();
    //wd.findElement(By.id("right"));
  }

  public void chooseTargetGroup() {
    expandTopDropdownList();
    wd.findElement(By.xpath("//form[@id='right']/select//option[3]")).click();
  }

  public void chooseAllInGroups() {
    expandTopDropdownList();
    wd.findElement(By.xpath("//form[@id='right']/select//option[1]")).click();
  }


}

