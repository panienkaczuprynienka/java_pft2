package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Addresses;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class AddressModificationTests extends TestBase {

@BeforeMethod
public void ensurePreconditions(){
  if(app.db().addresses().size()==0){
    app.goTo().homePage();
    app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot").withPersonalAddress("hk@wp.pl").withGroup("jep")), true);
  }
}

@Test
public void testAddressModification(){

  Addresses before = app.db().addresses();
  // wybieranie ktoregos elementu ze zbioru
  AddressData modifiedAddress = before.iterator().next();
  AddressData address = new AddressData()
          .withId(modifiedAddress.getId()).withFirstname("Żulana").withLastname("Huk").withPersonalAddress("hm@wp.pl");
  app.goTo().homePage();
  app.address().modify(address);
  Addresses after = app.db().addresses();
  assertEquals(after.size(), before.size());

  assertThat(after, equalTo(before.without(modifiedAddress).withAdded(address)));
  verityAddressListInUI();

}


}
