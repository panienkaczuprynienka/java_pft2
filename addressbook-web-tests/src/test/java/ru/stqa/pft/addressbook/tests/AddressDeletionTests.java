package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

public class AddressDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().list().size()==0) {
      app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot").withPersonalAddress("hk@wp.pl").withGroup("jep")), true);
    }
  }

  @Test
  public void testAddressDeletion() {
    List<AddressData> before = app.address().list();
    int index = before.size()-1;
    app.address().delete(index);
    app.goTo().homePage();
    List<AddressData> after = app.address().list();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(index);
    Assert.assertEquals(before, after);

  }



}
