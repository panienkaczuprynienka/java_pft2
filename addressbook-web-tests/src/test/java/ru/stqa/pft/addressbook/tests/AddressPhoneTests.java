package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class AddressPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.address().all().size() == 0) {
      app.address().create((new AddressData().withFirstname("Henek").withLastname("Kot").withPersonalAddress("hk@wp.pl").withGroup("jep")), true);
    }
  }

  @Test
  public void testAddressPhones() {
    app.goTo().homePage();
    AddressData address = app.address().all().iterator().next();
    AddressData addressInfoFromEditForm = app.address().infoFromEditForm(address);

    assertThat(address.getAllPhones(), equalTo(mergePhones(addressInfoFromEditForm)));
    assertThat(address.getAllEmails(), equalTo(mergeEmails(addressInfoFromEditForm)));
    assertThat(cleanedPersonalAddress(address.getPersonalAddress()), equalTo(cleanedPersonalAddress((addressInfoFromEditForm.getPersonalAddress()))));

  }


  private String mergePhones(AddressData address) {
    return Arrays.asList(address.getHomePhone(), address.getMobilePhone(), address.getWorkPhone(), address.getFaxPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(AddressPhoneTests::cleanedPhones)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(AddressData address) {
    return Arrays.asList(address.getEmail(), address.getEmail2(), address.getEmail3())
            .stream().filter((s) -> s != null && !s.equals(""))
            .map(AddressPhoneTests::cleanedEmails)
            .collect(Collectors.joining("\n"));
  }


  public static String cleanedPersonalAddress(String personalAddress) {
    return personalAddress.replaceAll("\\s", "").replaceAll("\\n", "");
  }

  public static String cleanedPhones(String phone) {

    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  public static String cleanedEmails(String email) {

    return email.replaceAll("\\s", "");
  }

}
