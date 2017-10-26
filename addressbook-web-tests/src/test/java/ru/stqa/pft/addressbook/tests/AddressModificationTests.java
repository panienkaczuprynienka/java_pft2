package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressModificationTests extends TestBase {


@Test(enabled=false)
public void testAddressModification(){
  app.goTo().goToHomePage();
  if (!app.getAddressHelper().isThereAnAddress()){
    app.getAddressHelper().createAddress((new AddressData("Zdzislawa", "Sledz", "z.s@wp.pl", "jep")), true);
  }
  List<AddressData> before = app.getAddressHelper().getAddressList();
  app.getAddressHelper().selectAddress(before.size()-1);
  app.getAddressHelper().editSelectedAddress(before.size()-1);
  AddressData address = new AddressData(before.get(before.size()-1).getId(),"Żulana", "Huk", "hm@wp.pl",null);
  app.getAddressHelper().fillAddressForm(address, false);
  app.getAddressHelper().submitAddressModification();
  app.getAddressHelper().returnToHomePage();
  List<AddressData> after = app.getAddressHelper().getAddressList();
  Assert.assertEquals(after.size(), before.size());

  before.remove(before.size()-1);
  before.add(address);
  Comparator<? super AddressData> byId = (a1, a2) ->Integer.compare(a1.getId(), a2.getId());
  before.sort(byId);
  after.sort(byId);
  Assert.assertEquals(before, after);
}
}
