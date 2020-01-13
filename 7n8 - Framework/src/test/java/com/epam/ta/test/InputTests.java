package com.epam.ta.test;

import com.epam.ta.page.RuHotelsHomePage;
import com.epam.ta.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTests extends CommonConditions {
    private static final String TESTDATA_JS_SCRIPT = "testdata.js.script";

    @Test
    public void cyrillicInputTest() {
        boolean isValidationInfoDisplayed = new RuHotelsHomePage(driver)
                .openRuHotelsAddHotelPage()
                .openRuHotelsPlaceYourObjectPage()
                .sendContactInfoWithFLNames("Дима", "Бобр")
                .isValidationInfoDisplayed();

        Assert.assertTrue(isValidationInfoDisplayed, "Cyrillic should be supported");
    }

    @Test
    public void checkInYesterdayDateInputTest() throws InterruptedException {
        boolean isHotelsListOpened = new RuHotelsHomePage(driver)
                .findHotelsWithDayBeforeTest()
                .isHotelsListOpened();

        Assert.assertFalse(isHotelsListOpened, "Date in the past should not be available for selection.");
    }

    @Test
    public void mapChooseTest() throws InterruptedException {
        boolean isAddressFieldFilled = new RuHotelsHomePage(driver)
                .openRuHotelsAddHotelPage()
                .openRuHotelsPlaceYourObjectPage()
                .sendDefaultContactInfo()
                .mapNavigate(53.8914656, 27.5596947)
                .isAddressFieldFilled();

        Assert.assertTrue(isAddressFieldFilled, "Choose address using map should be available");
    }

    @Test
    public void negativeNumberInputTest() {
        boolean isValidationInfoDisplayed = new RuHotelsHomePage(driver)
                .openRuHotelsAddHotelPage()
                .openRuHotelsPlaceYourObjectPage()
                .sendDefaultContactInfo()
                .sendNewHotelInfoWithRoomNumberParam("-1")
                .isValidationInfoDisplayed();

        Assert.assertTrue(isValidationInfoDisplayed, "Negative numbers should not be added");
    }

    @Test
    public void jsScriptsExecutionTest() {
        boolean isValidationMsgDisplayed = new RuHotelsHomePage(driver)
                .openRuHotelsGroupsAndMeetingsPage()
                .sendGroupBookingInfoWithCityParam(TestDataReader.getTestData(TESTDATA_JS_SCRIPT))
                .isValidationMsgDisplayed();

        Assert.assertTrue(isValidationMsgDisplayed, "Scripts should not be executed");
    }

    @Test
    public void languageChangeTest() {
        boolean isWhereToGoLabelLangChinese = new RuHotelsHomePage(driver)
                .clickLanguageList()
                .chooseChineseLang()
                .isWhereToGoLabelLangChinese();

        Assert.assertTrue(isWhereToGoLabelLangChinese, "Language should be available to change");
    }
}
