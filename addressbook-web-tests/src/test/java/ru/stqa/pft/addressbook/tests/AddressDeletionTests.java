package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

public class AddressDeletionTests extends TestBase {


    @Test
    public void testAddressDeletion() {
        app.goToAddressPage();
        app.editSelectedAddress();
        app.deleteSelectedAddress();
        app.goToHomePage();
    }


}
