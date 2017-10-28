package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressModificationTests extends TestBase {

@BeforeMethod
public void ensurePreconditions(){
  app.goTo().homePage();
  if (app.address().list().size()==0){
    app.address().create((new AddressData("Zdzislawa", "Sledz", "z.s@wp.pl", "jep")), true);
  }
}

@Test
public void testAddressModification(){

  List<AddressData> before = app.address().list();
  int index = before.size()-1;
  AddressData address = new AddressData(before.get(index).getId(),"Żulana", "Huk", "hm@wp.pl",null);
  app.address().modify(index, address);
  List<AddressData> after = app.address().list();
  Assert.assertEquals(after.size(), before.size());

  before.remove(index);
  before.add(address);
  Comparator<? super AddressData> byId = (a1, a2) ->Integer.compare(a1.getId(), a2.getId());
  before.sort(byId);
  after.sort(byId);
  Assert.assertEquals(before, after);
}


}
