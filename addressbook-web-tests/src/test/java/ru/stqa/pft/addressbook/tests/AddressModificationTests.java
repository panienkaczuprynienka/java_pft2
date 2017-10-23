package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

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
  app.getAddressHelper().fillAddressForm(new AddressData("Hulio", "Ljulio", "hl@gmail.com",null), false);
  app.getAddressHelper().submitAddressModification();
  app.getAddressHelper().returnToHomePage();
  List<AddressData> after = app.getAddressHelper().getAddressList();
  Assert.assertEquals(after.size(), before.size());
}
}
