package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.HashSet;
import java.util.List;

public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().goToHomePage();
    List<AddressData> before = app.getAddressHelper().getAddressList();
    AddressData address = new AddressData("Sylwia", "Zuk", "jz@wp.pl", "jep");
    app.getAddressHelper().createAddress((address), true);
    List<AddressData> after = app.getAddressHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size()+1);


    int max = 0;
    for (AddressData a : after){
      if (a.getId()>max) {
        max=a.getId();
      }
    }
    address.setId(max);
    before.add(address);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after));
  }
}


