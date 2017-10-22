package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressDeletionTests extends TestBase {


  @Test
  public void testAddressDeletion() {
    app.getNavigationHelper().goToHomePage();
        if (!app.getAddressHelper().isThereAnAddress()){
          app.getAddressHelper().createAddress((new AddressData("Zdzislawa", "Sledz", "z.s@wp.pl", "jep")), true);
        }
    int before = app.getAddressHelper().getAddressCount();
    app.getAddressHelper().editSelectedAddress();
    app.getAddressHelper().deleteSelectedAddress();
    app.getNavigationHelper().goToHomePage();
    int after = app.getAddressHelper().getAddressCount();
    Assert.assertEquals(after, before-1);
  }


}
