package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddressCreationTests extends TestBase {


  @Test(enabled=false)
  public void testAddressCreation() {
    app.goTo().homePage();
    Set<AddressData> before = app.address().all();
    AddressData address = new AddressData().withFirstname("Dzulietta").withLastname("Flak").withPersonalAddress("jf@wp.pl").withGroup("jep");
    app.address().create((address), true);
    Set<AddressData> after = app.address().all();
    Assert.assertEquals(after.size(), before.size()+1);

    address.withId(after.stream().mapToInt((a)->a.getId()).max().getAsInt());
    before.add(address);
    Assert.assertEquals(before, after);
  }
}


