package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase {



  @Test
  public void testAddressCreation() {

    app.goToAddressPage();
    app.getAddressHelper().fillAddressForm(new AddressData("Lukasz", "Lotysz", "l.lotysz@wp.pl"));
    app.getAddressHelper().submitAddressForm();
    app.getAddressHelper().goToHomePage();
  }
}


