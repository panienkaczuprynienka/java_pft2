package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase {



  @Test
  public void testAddressCreation() {

    app.getNavigationHelper().goToAddressPage();
    app.getAddressHelper().fillAddressForm(new AddressData("Ola", "Sledz", "ola.sledz@wp.pl", "Ladna"), true);
    app.getAddressHelper().submitAddressForm();
    app.getAddressHelper().goToHomePage();
  }
}


