package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class AddressPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().all().size()==0) {
      app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot").withPersonalAddress("hk@wp.pl").withGroup("jep")), true);
    }
  }

  @Test
  public void testAddressPhones(){
    app.goTo().homePage();
    AddressData address = app.address().all().iterator().next();
    AddressData addressInfoFromEditForm = app.address().infoFromEditForm(address);

    assertThat(address.getHomePhone(), equalTo(cleaned(addressInfoFromEditForm.getHomePhone())));
    assertThat(address.getMobilePhone(), equalTo(cleaned(addressInfoFromEditForm.getMobilePhone())));
    assertThat(address.getWorkPhone(), equalTo(cleaned(addressInfoFromEditForm.getWorkPhone())));
  }

  public String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

}
