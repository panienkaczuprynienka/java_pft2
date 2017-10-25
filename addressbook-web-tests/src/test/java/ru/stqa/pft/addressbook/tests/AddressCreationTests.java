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
    AddressData address = new AddressData("Judyta", "Szaflańska", "jsz@wp.pl", "jep");
    app.getAddressHelper().createAddress((address), true);
    List<AddressData> after = app.getAddressHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size()+1);


    address.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(address);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after));
  }
}


