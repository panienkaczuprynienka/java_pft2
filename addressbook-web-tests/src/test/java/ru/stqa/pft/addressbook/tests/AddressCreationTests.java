package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().goToHomePage();
    List<AddressData> before = app.getAddressHelper().getAddressList();
    app.getAddressHelper().createAddress((new AddressData("ewa", "luka", "el@wp.pl", "jep")), true);
    List<AddressData> after = app.getAddressHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size()+1);
  }
}


