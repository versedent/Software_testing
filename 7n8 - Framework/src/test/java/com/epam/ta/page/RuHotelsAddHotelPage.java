package com.epam.ta.page;

import com.epam.ta.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RuHotelsAddHotelPage extends AbstractPage{

    @FindBy(id = "joinUsButtonMasthead")
    private WebElement addHotelButton;

    public RuHotelsAddHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public RuHotelsPlaceYourObjectPage openRuHotelsPlaceYourObjectPage() {
        addHotelButton.click();

        DriverSingleton.waitElementLoaded(By.cssSelector("body"));
        return new RuHotelsPlaceYourObjectPage(this.driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
