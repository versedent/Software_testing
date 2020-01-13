package com.epam.ta.page;

import com.epam.ta.driver.DriverSingleton;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RuHotelsAddHotelInfoPage extends AbstractPage{

    private static final String HOTEL_NAME = "Beautiful Museum";
    private static final String NUMBER_OF_ROOMS = "100";

    @FindBy(name = "localizedPropertyName")
    private WebElement hotelName;

    @FindBy(name = "location")
    private WebElement hotelLocation;

    @FindBy(className = "pac-item")
    private WebElement locationSearchResult;

    @FindBy(name = "propertyType")
    private WebElement objectType;

    @FindBy(xpath = "//*/div[2]/div/div[1]/select/option[3]")
    private WebElement apartmentOption;

    @FindBy(name = "numOfRooms")
    private WebElement numberOfRooms;

    @FindBy(name = "currency")
    private Select currency;

    @FindBy(xpath = "//button[@name='worksWithChannelManager'][2]")
    private WebElement worksWithChannelManagerButtonNo;

    @FindBy(xpath = "//button[@name='partOfChain'][2]")
    private WebElement partOfChainButtonNo;

    @FindBy(className = "btn-primary")
    private WebElement continueButton;

    @FindBy(className = "welcome")
    private WebElement welcomeText;

    @FindBy(xpath = "//div[text()='Belarusian State Technological University']")
    private WebElement belstuMarker;

    @FindBy(xpath = "//input[@placeholder='Адрес объекта размещения']")
    private WebElement addressPlaceholder;

    @FindBy(className = "validation-msg")
    private WebElement validationInfo;

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public RuHotelsAddHotelInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RuHotelsAddHotelInfoPage sendNewHotelInfoWithAddressParam(String address) {
        hotelName.sendKeys(HOTEL_NAME);
        hotelLocation.sendKeys(address);

        DriverSingleton.waitElementLoaded(By.cssSelector("body > div.pac-container.pac-logo.hdpi"));

        locationSearchResult.click();
        objectType.click();
        apartmentOption.click();
        numberOfRooms.sendKeys(NUMBER_OF_ROOMS);
        worksWithChannelManagerButtonNo.click();
        partOfChainButtonNo.click();
        continueButton.click();

        DriverSingleton.waitElementLoaded(By.id("confirmation"));
        return new RuHotelsAddHotelInfoPage(this.driver);
    }

    public RuHotelsAddHotelInfoPage sendNewHotelInfoWithRoomNumberParam(String numberOfRooms) {
        hotelName.sendKeys(HOTEL_NAME);
        hotelLocation.sendKeys("Stafford ST17 0RN, UK");

        DriverSingleton.waitElementLoaded(By.cssSelector("body > div.pac-container.pac-logo.hdpi"));

        locationSearchResult.click();
        objectType.click();
        apartmentOption.click();
        this.numberOfRooms.sendKeys(numberOfRooms);
        worksWithChannelManagerButtonNo.click();
        partOfChainButtonNo.click();
        continueButton.click();

        return new RuHotelsAddHotelInfoPage(this.driver);
    }

    public RuHotelsAddHotelInfoPage approveInfo() {
        continueButton.click();

        DriverSingleton.waitElementLoaded(By.id("success"));
        return this;
    }

    public RuHotelsAddHotelInfoPage mapNavigate(double latitude, double longitude) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(5000);

        String jsScript = "var map;\n" +
                "myLatlng = {lat: " + latitude + ", lng: " + longitude + "};" +
                "    var myOptions = {\n" +
                "      center: myLatlng,\n" +
                "      zoom: 17,\n" +
                "      mapTypeId: google.maps.MapTypeId.ROADMAP\n" +
                "    };\n" +
                "    var mapDiv = document.getElementsByClassName('map')[0];\n" +
                "    map = new google.maps.Map(mapDiv, myOptions);\n";

        js.executeScript(jsScript);
        Thread.sleep(3000);
        return this;
    }

    public boolean isAddressFieldFilled() throws InterruptedException {
        WebElement markerImage = driver.findElement(By.className("map"));

        Actions actions = new Actions(driver);
        actions.moveToElement(markerImage).perform();
        actions.click().build().perform();

        Thread.sleep(2000);

        return belstuMarker != null && StringUtils.isNotBlank(addressPlaceholder.getText());
    }

    public boolean isValidationInfoDisplayed() {
        return validationInfo.isDisplayed();
    }

    public boolean isWelcomeTextDisplayed() {
        return welcomeText.isDisplayed();
    }
}
