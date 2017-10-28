package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.goTo().homePage();
    List<AddressData> before = app.address().list();
    AddressData address = new AddressData().withFirstname("Dzulietta").withLastname("Flak").withPersonalAddress("jf@wp.pl").withGroup("jep");
    app.address().create((address), true);
    List<AddressData> after = app.address().list();
    Assert.assertEquals(after.size(), before.size()+1);


    before.add(address);
    Comparator<? super AddressData> byId = (a1, a2) ->Integer.compare(a1.getId(), a2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}


