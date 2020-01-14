package com.epam.ta.page;

import com.epam.ta.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RuHotelsAddHotelPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "joinUsButtonMasthead")
    private WebElement addHotelButton;

    public RuHotelsAddHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        logger.info("RuHotels 'Add hotel page' has been opened");
    }

    public RuHotelsPlaceYourObjectPage openRuHotelsPlaceYourObjectPage() {
        addHotelButton.click();

        logger.info("RuHotels 'Place your object' link clicked");
        DriverSingleton.waitElementLoaded(By.cssSelector("body"));
        return new RuHotelsPlaceYourObjectPage(this.driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
