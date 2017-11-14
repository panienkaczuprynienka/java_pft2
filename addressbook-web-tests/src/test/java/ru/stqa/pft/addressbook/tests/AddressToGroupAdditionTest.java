package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Addresses;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class AddressToGroupAdditionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().addresses().size() == 0) {
      app.goTo().homePage();
      app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot").withPersonalAddress("hk@wp.pl")), true);
    }

    if(app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("grupa1"));
    }
  }




  @Test
  public void testAddressToGroupAddition() {
    app.goTo().homePage();
    app.address().chooseTargetGroup();
    Addresses beforeAddiction = app.address().all();
    System.out.println(beforeAddiction.size());

    //app.address().chooseAllInGroups();
    app.goTo().mainPage();
    Addresses before = app.address().all();
    System.out.println(before.size());

    AddressData movedAddress = before.iterator().next();
    app.address().move(movedAddress);
    //app.address().goToLastGroupPage();
    app.goTo().mainPage();
    app.address().chooseTargetGroup();
    Addresses afterAddiction = app.address().all();
    System.out.println(afterAddiction.size());

    assertThat(beforeAddiction.size(), equalTo(afterAddiction.size() - 1));
    //app.address().chooseAllInGroups();

    app.goTo().mainPage();
    Addresses after = app.address().all();
    System.out.println(after.size());

    assertThat(before.size(), equalTo(after.size()));
    verifyGroupListInUI();
    verifyAddressListInUI();
  }


}
