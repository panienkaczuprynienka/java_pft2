package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

public class AddressDeletionTests extends TestBase {


    @Test
    public void testAddressDeletion() {
        goToAddressPage();
        editSelectedAddress();
        deleteSelectedAddress();
        goToHomePage();
    }


}
