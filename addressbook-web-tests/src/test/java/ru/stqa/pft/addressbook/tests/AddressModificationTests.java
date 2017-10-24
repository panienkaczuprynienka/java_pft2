package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.HashSet;
import java.util.List;

public class AddressModificationTests extends TestBase {


@Test
public void testAddressModification(){
  app.getNavigationHelper().goToHomePage();
  if (!app.getAddressHelper().isThereAnAddress()){
    app.getAddressHelper().createAddress((new AddressData("Zdzislawa", "Sledz", "z.s@wp.pl", "jep")), true);
  }
  List<AddressData> before = app.getAddressHelper().getAddressList();
  app.getAddressHelper().selectAddress(before.size()-1);
  app.getAddressHelper().editSelectedAddress(before.size()-1);
  AddressData address = new AddressData(before.get(before.size()-1).getId(),"Helena", "Mak", "hm@wp.pl",null);
  app.getAddressHelper().fillAddressForm(address, false);
  app.getAddressHelper().submitAddressModification();
  app.getAddressHelper().returnToHomePage();
  List<AddressData> after = app.getAddressHelper().getAddressList();
  Assert.assertEquals(after.size(), before.size());

  before.remove(before.size()-1);
  before.add(address);
  Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after));
}
}
