package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

public class AddressDeletionTests extends TestBase {


  @Test
  public void testAddressDeletion() {
    app.getNavigationHelper().goToHomePage();
        if (!app.getAddressHelper().isThereAnAddress()){
          app.getAddressHelper().createAddress((new AddressData("Zdzislawa", "Sledz", "z.s@wp.pl", "jep")), true);
        }
    List<AddressData> before = app.getAddressHelper().getAddressList();
    app.getAddressHelper().selectAddress(before.size()-1);
    app.getAddressHelper().deleteAddress();
    app.getAddressHelper().okAlert();
    app.getNavigationHelper().goToHomePage();
    List<AddressData> after = app.getAddressHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);

  }

}
