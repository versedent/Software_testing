import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class WebDriverTest {

    @Test
    public void dayBeforeCheckInDateTest(){
        WebDriver driver = new ChromeDriver();

        TestUtils.testSearchForm(driver, TestUtils.getYesterdayDate());

        List<WebElement> errorElement = driver.findElements(By.cssSelector("div.form-error"));

        Assert.assertFalse(errorElement.isEmpty());
    }

    @Test
    public void hotelSearchTest(){
        WebDriver driver = new ChromeDriver();

        TestUtils.testSearchForm(driver, String.valueOf(LocalDateTime.now()));

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(WebDriverException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));

        List<WebElement> resultsList = driver.findElements(By.cssSelector("#listings > ol > li"));

        Assert.assertFalse(resultsList.isEmpty());
    }
}