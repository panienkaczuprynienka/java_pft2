package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

public class AddressCreationTests extends TestBase {



  @Test
  public void testAddressCreation() {

    goToAddressPage();
    fillAddressForm(new AddressData("Lukasz", "Lotysz", "l.lotysz@wp.pl"));
    submitAddressForm();
    goToHomePage();
  }
}


