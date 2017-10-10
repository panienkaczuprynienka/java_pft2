package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AddressDeletionTests extends TestBase {


    @Test
    public void testAddressDeletion() {
        app.goToAddressPage();
        app.getAddressHelper().editSelectedAddress();
        app.getAddressHelper().deleteSelectedAddress();
        app.getAddressHelper().goToHomePage();
    }


}
