package pageobject_model.test;

import org.junit.Assert;
import org.junit.Test;
import pageobject_model.page.RuHotelsHomePage;

public class WebDriverPageObjectTest {

    private static final String HOTEL_ADDRESS = "1220 5th Ave, New York, NY 10029, США";

    @Test
    public void addHotelWithPublicPlaceTest() {

        boolean addHotelResultMessage = new RuHotelsHomePage()
                .openPage()
                .openRuHotelsAddHotel()
                .openRuHotelsPlaceYourObjectPage()
                .sendContactInfo()
                .sendNewHotelInfoWithAddress(HOTEL_ADDRESS)
                .approveInfo()
                .isWelcomeTextDisplayed();

        Assert.assertFalse("Welcome message is not applicable", addHotelResultMessage);
    }
}
