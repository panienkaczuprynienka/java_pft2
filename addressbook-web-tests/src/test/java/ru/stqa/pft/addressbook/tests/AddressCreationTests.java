package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Addresses;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validAddressesFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/addresses.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(AddressData.class);
      List<AddressData> addresses = (List<AddressData>) xstream.fromXML(xml);
      return addresses.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validAddressesFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/addresses.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<AddressData> addresses = gson.fromJson(json, new TypeToken<List<AddressData>>() {
      }.getType()); //List<AddressData>.class
      return addresses.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  // jesli chchec korzystac z dtata providera to trzeba takie cos dopisac po zapisku test (dataProvider = "validAddressesFromXml")

  @BeforeMethod
  public void ensurePreconditions(){
    if(app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testAddressCreation(AddressData address) {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/fotografia.png");
    AddressData newAddress = new AddressData().withFirstname("imie").withLastname("nazwisko")
            .withPhoto(photo).inGroup(groups.iterator().next());
    app.goTo().homePage();
    Addresses before = app.db().addresses();
    app.address().create((newAddress), true);
    Addresses after = app.db().addresses();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(address.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
    verifyAddressListInUI();
  }



  /*
@Test
  public void testCurrentDir(){
    File currentDir = new File(".");
  System.out.println(currentDir.getAbsolutePath());
  File photo = new File("src/test/resources/fotografia.png");
  System.out.println(photo.getAbsolutePath());
  System.out.println(photo.exists());

}
*/

}


