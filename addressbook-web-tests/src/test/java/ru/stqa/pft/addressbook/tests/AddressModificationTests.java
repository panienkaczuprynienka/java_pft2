package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase {


@Test
public void testAddressModification(){
  app.getNavigationHelper().goToHomePage();
  if (!app.getAddressHelper().isThereAnAddress()){
    app.getAddressHelper().createAddress((new AddressData("Zdzislawa", "Sledz", "z.s@wp.pl", null)), true);
  }
  app.getAddressHelper().editSelectedAddress();
  app.getAddressHelper().fillAddressForm(new AddressData("Sylwia", null, "hops@gmail.com",null), false);
  app.getAddressHelper().submitAddressModification();
  app.getAddressHelper().returnToHomePage();
}
}
