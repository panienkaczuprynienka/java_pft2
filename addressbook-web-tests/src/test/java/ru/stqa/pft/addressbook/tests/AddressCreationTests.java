package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().goToHomePage();
    int before = app.getAddressHelper().getAddressCount();
    app.getAddressHelper().createAddress((new AddressData("hola", "Sledz", "ola.sledz@wp.pl", "jep")), true);
    int after = app.getAddressHelper().getAddressCount();
    Assert.assertEquals(after, before+1);
  }
}


