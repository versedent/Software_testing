package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject_model.browser.Browser;

import java.util.ArrayList;
import java.util.List;

public class RuHotelsHomePage {
    private static final String HOMEPAGE_URL = "https://ru.hotels.com/";

    @FindBy(xpath = "//*/nav[2]/div/ul/li[3]/a")
    private WebElement addHotelLink;

    public RuHotelsHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public RuHotelsHomePage openPage() {
        Browser.getDriver().get(HOMEPAGE_URL);
        new WebDriverWait(Browser.getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        return this;
    }

    public RuHotelsAddHotelPage openRuHotelsAddHotel() {
        addHotelLink.click();

        List<String> browserTabs = new ArrayList<String>(Browser.getDriver().getWindowHandles());
        Browser.getDriver().switchTo().window(browserTabs.get(1));

        new WebDriverWait(Browser.getDriver(), 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        return new RuHotelsAddHotelPage(Browser.getDriver());
    }
}
