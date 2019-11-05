import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestUtils {
    private static String DESTINATION_CITY = "Москва";
    private static String CHECK_OUT = "08/11/2019";
    private static String OCCUPANCY = "Другие варианты...";
    private static String ROOMS = "1";
    private static String ROOMS_ADULTS = "2";
    private static String ROOMS_CHILDREN = "1";
    private static String CHILD_AGE = "9";

    public static void testSearchForm(WebDriver driver, String checkInDate) {

        driver.get("https://ru.hotels.com");

        WebElement destinationInput = driver.findElement(By.id("qf-0q-destination"));
        WebElement checkIn = driver.findElement(By.id("qf-0q-localised-check-in"));
        WebElement checkOut = driver.findElement(By.id("qf-0q-localised-check-out"));
        Select occupancy = new Select(driver.findElement(By.id("qf-0q-compact-occupancy")));
        Select rooms = new Select(driver.findElement(By.id("qf-0q-rooms")));
        Select roomAdults = new Select(driver.findElement(By.id("qf-0q-room-0-adults")));
        Select roomChildren = new Select(driver.findElement(By.id("qf-0q-room-0-children")));
        WebElement findButton = driver.findElement(By.xpath("//*[@id=\"hds-marquee\"]/div[2]/div[1]/div/form/div[5]/button"));

        destinationInput.sendKeys(DESTINATION_CITY);

        checkIn.clear();
        checkIn.sendKeys(checkInDate);

        checkOut.clear();
        checkOut.sendKeys(CHECK_OUT);

        occupancy.selectByVisibleText(OCCUPANCY);
        rooms.selectByValue(ROOMS);
        roomAdults.selectByValue(ROOMS_ADULTS);
        roomChildren.selectByValue(ROOMS_CHILDREN);

        Select childAge = new Select(driver.findElement(By.id("qf-0q-room-0-child-0-age")));
        childAge.selectByValue(CHILD_AGE);

        findButton.click();
    }

    public static String getYesterdayDate(){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now().minusDays(1));
    }
}
