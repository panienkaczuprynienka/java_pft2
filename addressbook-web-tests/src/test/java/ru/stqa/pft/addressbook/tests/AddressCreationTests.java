package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Addresses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase {


  @Test
  public void testAddressCreation() {
    app.goTo().homePage();
    Addresses before = app.address().all();
    File photo = new File("src/test/resources/fotografia.png");
    AddressData address = new AddressData().withFirstname("Dzulietta").withLastname("Flak")
            .withPersonalAddress("jf@wp.pl").withPhoto(photo);
    app.address().create((address), true);
    Addresses after = app.address().all();
    assertThat(after.size(), equalTo(before.size()+1));

    assertThat(after, equalTo(
            before.withAdded(address.withId(after.stream().mapToInt((a)->a.getId()).max().getAsInt()))));
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


