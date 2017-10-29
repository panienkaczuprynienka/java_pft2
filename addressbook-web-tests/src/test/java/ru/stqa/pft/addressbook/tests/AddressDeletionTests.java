package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;
import java.util.Set;

public class AddressDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().list().size()==0) {
      app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot").withPersonalAddress("hk@wp.pl").withGroup("jep")), true);
    }
  }

  @Test(enabled=false)
  public void testAddressDeletion() {
    Set<AddressData> before = app.address().all();
    //zwracanie poierwszego znalezionego elementu zbioru
    AddressData deletedAddress = before.iterator().next();
    int index = before.size()-1;
    app.address().delete(deletedAddress);
    app.goTo().homePage();
    Set<AddressData> after = app.address().all();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(deletedAddress);
    Assert.assertEquals(before, after);

  }



}
