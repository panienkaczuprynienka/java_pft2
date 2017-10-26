package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressCreationTests extends TestBase {


  @Test(enabled=false)
  public void testAddressCreation() {
    app.goTo().goToHomePage();
    List<AddressData> before = app.getAddressHelper().getAddressList();
    AddressData address = new AddressData("Elżbieta", "Henke", "jsz@wp.pl", "jep");
    app.getAddressHelper().createAddress((address), true);
    List<AddressData> after = app.getAddressHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size()+1);


    before.add(address);
    Comparator<? super AddressData> byId = (a1, a2) ->Integer.compare(a1.getId(), a2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}


