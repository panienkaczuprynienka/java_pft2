package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Addresses;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressFromGroupRemovalTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if(app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("grupa1"));
    }

    if (app.db().addresses().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().homePage();
      app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot")
              .withPersonalAddress("hk@wp.pl").inGroup(groups.iterator().next())), true);
    }

  }


  @Test
  public void testAddressFromGroupRemoval() {
    app.goTo().homePage();
    Addresses before = app.address().all();
    System.out.println(before.size());

    app.address().chooseTargetGroup();
    Addresses beforeRemoval = app.address().all();
    System.out.println(beforeRemoval.size());

    AddressData removedAddress = before.iterator().next();

    app.address().remove(removedAddress);
    app.goTo().homePage();
    Addresses afterRemoval = app.address().all();
    System.out.println(afterRemoval.size());

    app.goTo().mainPage();
    Addresses after = app.address().all();
    System.out.println(after.size());


    assertThat(beforeRemoval.size(), equalTo(afterRemoval.size() + 1));
    assertThat(before.size(), equalTo(after.size()));



  }

}
