package com.epam.ta.test;

import com.epam.ta.page.RuHotelsHomePage;
import com.epam.ta.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddHotelTests extends CommonConditions {
    private static final String TESTDATA_NEW_HOTEL_ADDRESS = "testdata.new.hotel.address";
    private static final String TESTDATA_PUBLIC_PLACE_ADDRESS = "testdata.public.place.address";

    @Test
    public void addHotel() {
        boolean isAddHotelWelcomeMsgDisplayed = new RuHotelsHomePage(driver)
                .openRuHotelsAddHotelPage()
                .openRuHotelsPlaceYourObjectPage()
                .sendDefaultContactInfo()
                .sendNewHotelInfoWithAddressParam(TestDataReader.getTestData(TESTDATA_NEW_HOTEL_ADDRESS))
                .approveInfo()
                .isWelcomeTextDisplayed();

        Assert.assertTrue(isAddHotelWelcomeMsgDisplayed, "Usual place can be added as hotel");
    }

    @Test
    public void addHotelWithPublicPlaceTest() {
        boolean isAddHotelWelcomeMsgDisplayed = new RuHotelsHomePage(driver)
                .openRuHotelsAddHotelPage()
                .openRuHotelsPlaceYourObjectPage()
                .sendDefaultContactInfo()
                .sendNewHotelInfoWithAddressParam(TestDataReader.getTestData(TESTDATA_PUBLIC_PLACE_ADDRESS))
                .approveInfo()
                .isWelcomeTextDisplayed();

        Assert.assertFalse(isAddHotelWelcomeMsgDisplayed, "Public place as new hotel should not be added");
    }
}
