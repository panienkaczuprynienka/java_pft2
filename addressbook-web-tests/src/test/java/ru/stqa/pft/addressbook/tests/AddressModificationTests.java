package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddressModificationTests extends TestBase {

@BeforeMethod
public void ensurePreconditions(){
  app.goTo().homePage();
  if (app.address().list().size()==0){
    app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot").withPersonalAddress("hk@wp.pl").withGroup("jep")), true);
  }
}

@Test(enabled=false)
public void testAddressModification(){

  Set<AddressData> before = app.address().all();
  // wybieranie ktoregos elementu ze zbioru
  AddressData modifiedAddress = before.iterator().next();
  AddressData address = new AddressData()
          .withId(modifiedAddress.getId()).withFirstname("Żulana").withLastname("Huk").withPersonalAddress("hm@wp.pl");
  app.address().modify(address);
  Set<AddressData> after = app.address().all();
  Assert.assertEquals(after.size(), before.size());

  before.remove(modifiedAddress);
  before.add(address);
  Assert.assertEquals(before, after);
}


}
