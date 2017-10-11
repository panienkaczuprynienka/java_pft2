package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase {


@Test
public void testAddressModification(){
  app.getAddressHelper().editSelectedAddress();
  app.getAddressHelper().fillAddressForm(new AddressData("Ewa", "Zalewska", "e.z@wp.pl"));
  app.getAddressHelper().submitAddressModification();
  app.getAddressHelper().goToHomePage();
}
}
