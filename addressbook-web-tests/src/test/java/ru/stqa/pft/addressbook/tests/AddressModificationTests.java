package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase {


@Test
public void testAddressModification(){
  app.getNavigationHelper().goToHomePage();
  if (!app.getAddressHelper().isThereAnAddress()){
    app.getAddressHelper().createAddress((new AddressData("Zdzislawa", "Sledz", "z.s@wp.pl", "jep")), true);
  }
  int before = app.getAddressHelper().getAddressCount();
  app.getAddressHelper().selectAddress(before-1);
  //tutaj edytuje się i tak pierwszy z góry a nie wybrany metodą selectAddress
  app.getAddressHelper().editSelectedAddress();
  app.getAddressHelper().fillAddressForm(new AddressData("Sylwia", null, "hops@gmail.com",null), false);
  app.getAddressHelper().submitAddressModification();
  app.getAddressHelper().returnToHomePage();
  int after = app.getAddressHelper().getAddressCount();
  Assert.assertEquals(after, before);
}
}
