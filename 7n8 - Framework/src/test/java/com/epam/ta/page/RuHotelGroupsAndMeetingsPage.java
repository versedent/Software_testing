package com.epam.ta.page;

import com.epam.ta.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RuHotelGroupsAndMeetingsPage {
    private final Logger logger = LogManager.getRootLogger();
    private static String ROOMS_NUMBER = "2";
    private static String CLIENT_FULL_NAME = "Rick Dalton";
    private static String CLIENT_EMAIL_ADDRESS = "rick.dalton@gmail.com";

    @FindBy(id = "txtCity1")
    private WebElement cityInput;

    @FindBy(id = "CheckInDate1_disp")
    private WebElement checkInDatePlaceholder;

    @FindBy(xpath = "//*[@class=\"ui-datepicker-calendar\"]/tbody/tr[4]/td[3]/a")
    private WebElement checkInDateSelection;

    @FindBy(xpath = "//*[@class=\"ui-datepicker-calendar\"]/tbody/tr[5]/td[3]/a")
    private WebElement checkOutDateSelection;

    @FindBy(id = "groupType")
    private WebElement groupTypeList;

    @FindBy(xpath = "//*[@id=\"groupType\"]/option[28]")
    private WebElement groupTypeOtherSelection;

    @FindBy(id = "rooms")
    private WebElement roomsNumberInput;

    @FindBy(xpath = "//*[@id=\"starRatingRow\"]//button")
    private WebElement starRatingList;

    @FindBy(xpath = "//*[@id=\"starRatingRow\"]//li[7]")
    private WebElement starRatingFiveStarsSelection;

    @FindBy(id = "FullName")
    private WebElement fullNameInput;

    @FindBy(id = "input-email")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//*[@id=\"frmRequestSmart\"]/button")
    private WebElement submitButton;

    public RuHotelGroupsAndMeetingsPage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
        logger.info("Ru hotels groups and meetings page opened");
    }

    public RuHotelGroupsAndMeetingsPage sendGroupBookingInfoWithCityParam(String cityParam) {
        cityInput.sendKeys(cityParam);
        checkInDatePlaceholder.click();
        checkInDateSelection.click();
        checkOutDateSelection.click();
        groupTypeList.click();
        groupTypeOtherSelection.click();
        roomsNumberInput.sendKeys(ROOMS_NUMBER);
        starRatingList.click();
        starRatingFiveStarsSelection.click();
        DriverSingleton.waitElementLoaded(By.id("FullName"));
        fullNameInput.sendKeys(CLIENT_FULL_NAME);
        emailAddressInput.sendKeys(CLIENT_EMAIL_ADDRESS);

        submitButton.click();
        logger.info("Group booking info sent with city param");
        return this;
    }

    public boolean isValidationMsgDisplayed() {
        return !DriverSingleton.getDriver()
                .findElements(By.ByXPath
                        .xpath("//*[@id=\"group-form-destination\"]" +
                                "/div[1]/div[1]/div/span[1]")).isEmpty();
    }
}
