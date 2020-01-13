package com.epam.ta.page;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class RuHotelsHomePage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://ru.hotels.com/";

    private static String DESTINATION_CITY = "Москва";

    @FindBy(id = "qf-0q-destination")
    private WebElement destinationInput;

    @FindBy(className = "close-icon")
    private WebElement notCityListItem;

    @FindBy(id = "widget-query-label-1")
    private WebElement checkIn;

    @FindBy(xpath = "//td[@data-date='2020-0-10']")
    private WebElement tenJanuary;

    @FindBy(xpath = "//button[text()='Поиск']")
    private WebElement findButton;

    @FindBy(xpath = "//*/nav[2]/div/ul/li[3]/a")
    private WebElement addHotelLink;

    @FindBy(id = "hdr-groups")
    private WebElement groupsAndMeetingsLink;

    @FindBy(id = "header-toggle-pos")
    private WebElement chooseLanguageButton;

    @FindBy(xpath = "//a[@lang='zh-HK']")
    private WebElement chineseLanguageRef;

    @FindBy(className = "cont-hd-alt")
    private WebElement whereToGoLabel;

    public RuHotelsHomePage(WebDriver driver) {
        super(driver);
        DriverSingleton.getUrl(HOMEPAGE_URL);
        PageFactory.initElements(this.driver, this);
    }

    public RuHotelsHomePage findHotels(String addi) throws InterruptedException {
        destinationInput.sendKeys(DESTINATION_CITY + addi);
        Thread.sleep(2000);
        notCityListItem.click();
        Thread.sleep(1000);
        checkIn.click();
        Thread.sleep(1000);
        tenJanuary.click();
        Thread.sleep(500);
        findButton.click();

        return this;
    }

    public RuHotelsHomePage findHotelsWithDayBeforeTest() throws InterruptedException {
        destinationInput.sendKeys(DESTINATION_CITY);
        Thread.sleep(2000);
        notCityListItem.click();
        Thread.sleep(1000);
        checkIn.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@data-date='" + StringUtils.getYesterdayDate() + "']")).click();
        Thread.sleep(500);
        findButton.click();

        return this;
    }

    public boolean isHotelsListOpened() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));

        List<WebElement> resultsList = driver.findElements(By.cssSelector("#listings > ol > li"));
        return !resultsList.isEmpty();
    }

    public RuHotelsAddHotelPage openRuHotelsAddHotelPage() {
        addHotelLink.click();

        DriverSingleton.switchTab(1);
        return new RuHotelsAddHotelPage(driver);
    }

    public RuHotelGroupsAndMeetingsPage openRuHotelsGroupsAndMeetingsPage() {
        groupsAndMeetingsLink.click();

        DriverSingleton.switchTab(1);
        return new RuHotelGroupsAndMeetingsPage();
    }

    public RuHotelsHomePage clickLanguageList() {
        chooseLanguageButton.click();
        DriverSingleton.waitElementLoaded(By.xpath("//a[@lang='zh-HK']"));

        return this;
    }

    public RuHotelsHomePage chooseChineseLang() {
        chineseLanguageRef.click();
        DriverSingleton.waitElementLoaded(By.cssSelector("body"));

        return this;
    }

    public boolean isWhereToGoLabelLangChinese() {
        String whereToGoLabelText = whereToGoLabel.getText();
        return whereToGoLabelText.equals("你想去哪裡？");
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
