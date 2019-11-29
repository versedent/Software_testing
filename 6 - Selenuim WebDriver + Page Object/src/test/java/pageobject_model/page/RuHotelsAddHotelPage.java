package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RuHotelsAddHotelPage {

    WebDriver driver;

    @FindBy(id = "joinUsButtonMasthead")
    private WebElement addHotelButton;

    public RuHotelsAddHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RuHotelsPlaceYourObjectPage openRuHotelsPlaceYourObjectPage() {
        addHotelButton.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        return new RuHotelsPlaceYourObjectPage(driver);
    }
}
