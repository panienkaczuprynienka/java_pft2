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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddressDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().addresses().size()==0){
      app.goTo().homePage();
      app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot").withPersonalAddress("hk@wp.pl").withGroup("jep")), true);
    }
  }

  @Test
  public void testAddressDeletion() {
    Addresses before = app.db().addresses();
    //zwracanie poierwszego znalezionego elementu zbioru
    AddressData deletedAddress = before.iterator().next();
    int index = before.size()-1;
    app.goTo().homePage();
    app.address().delete(deletedAddress);
    app.goTo().homePage();
    Addresses after = app.db().addresses();
    assertEquals(after.size(), before.size()-1);

    assertThat(after, equalTo(before.without(deletedAddress)));
    verityAddressListInUI();
  }



}
