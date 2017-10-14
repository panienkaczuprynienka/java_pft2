package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().goToHomePage();
    app.getAddressHelper().createAddress((new AddressData("Ola", "Sledz", "ola.sledz@wp.pl", "jakas")), true);
  }
}


