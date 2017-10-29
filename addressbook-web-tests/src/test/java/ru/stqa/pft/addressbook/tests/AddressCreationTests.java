package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Addresses;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.goTo().homePage();
    Addresses before = app.address().all();
    AddressData address = new AddressData().withFirstname("Dzulietta").withLastname("Flak").withPersonalAddress("jf@wp.pl").withGroup("jep");
    app.address().create((address), true);
    Addresses after = app.address().all();
    assertThat(after.size(), equalTo(before.size()+1));

    assertThat(after, equalTo(
            before.withAdded(address.withId(after.stream().mapToInt((a)->a.getId()).max().getAsInt()))));
  }
}


