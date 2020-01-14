package com.epam.ta.page;

import com.epam.ta.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RuHotelsPlaceYourObjectPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private static final String FIRST_NAME_PARAMETER = "Rick";
    private static final String LAST_NAME_PARAMETER = "Grimes";
    private static final String EMAIL_ADDRESS_PARAMETER = "wivoci8006@xmailweb.com";
    private static final String PHONE_NUMBER_PARAMETER = "509333620";

    @FindBy(className = "btn-primary")
    private WebElement addHotelButton;

    @FindBy(name = "localFirstName")
    private WebElement firstName;

    @FindBy(name = "localLastName")
    private WebElement lastName;

    @FindBy(name = "emailAddress")
    private WebElement emailAddress;

    @FindBy(name = "countryCode")
    private WebElement countryCode;

    @FindBy(xpath = "//*[@id=\"joinForm\"]/form/div[2]/div[6]/div[1]/select/option[202]")
    private WebElement ukrOption;

    @FindBy(name = "phoneNumber")
    private WebElement phoneNumber;

    @FindBy(className = "validation-msg")
    private WebElement validationInfo;

    public RuHotelsPlaceYourObjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        logger.info("'Place your object' page has been opened");
    }

    public RuHotelsAddHotelInfoPage sendDefaultContactInfo(){
        List<String> browserTabs = new ArrayList<String>(this.driver.getWindowHandles());
        this.driver.switchTo().window(browserTabs.get(2));

        firstName.sendKeys(FIRST_NAME_PARAMETER);
        lastName.sendKeys(LAST_NAME_PARAMETER);
        emailAddress.sendKeys(EMAIL_ADDRESS_PARAMETER);
        phoneNumber.sendKeys(PHONE_NUMBER_PARAMETER);
        countryCode.click();
        ukrOption.click();
        addHotelButton.click();

        DriverSingleton.waitElementLoaded(By.cssSelector("iframe"));
        logger.info("Default contact information has been sent");
        return new RuHotelsAddHotelInfoPage(this.driver);
    }

    public RuHotelsPlaceYourObjectPage sendContactInfoWithFLNames(String firstName, String lastName){
        List<String> browserTabs = new ArrayList<String>(this.driver.getWindowHandles());
        this.driver.switchTo().window(browserTabs.get(2));

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        emailAddress.sendKeys(EMAIL_ADDRESS_PARAMETER);
        phoneNumber.sendKeys(PHONE_NUMBER_PARAMETER);
        countryCode.click();
        ukrOption.click();
        addHotelButton.click();

        logger.info("Contact info with first and last names parameters has been sent");
        return this;
    }

    public boolean isValidationInfoDisplayed() {
        return validationInfo.isDisplayed();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
