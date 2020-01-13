package com.epam.ta.test;

import com.epam.ta.page.RuHotelsHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelSearchTests extends CommonConditions {

    @Test
    public void searchFormTest() throws InterruptedException {
        boolean isHotelsListOpened = new RuHotelsHomePage(driver)
                .findHotels("")
                .isHotelsListOpened();

        Assert.assertTrue(isHotelsListOpened, "Search with default info should be proceed");
    }

    @Test
    public void extraKeysInputTest() throws InterruptedException {
        boolean isHotelsListOpened = new RuHotelsHomePage(driver)
                .findHotels("$#@%")
                .isHotelsListOpened();

        Assert.assertFalse(isHotelsListOpened, "In case of wrong input search should not be proceed");
    }
}
