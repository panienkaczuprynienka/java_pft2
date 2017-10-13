package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase {



  @Test
  public void testAddressCreation() {

    app.getNavigationHelper().goToAddressPage();
    app.getAddressHelper().fillAddressForm(new AddressData("Ewa", "Farna", "ewa.farna@wp.pl"));
    app.getAddressHelper().submitAddressForm();
    app.getAddressHelper().goToHomePage();
  }
}


