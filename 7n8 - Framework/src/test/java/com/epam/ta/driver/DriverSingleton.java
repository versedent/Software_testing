package com.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void getUrl(String url) {
        getDriver().get(url);
        waitElementLoaded(By.cssSelector("body"));
    }

    public static void closeDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void waitElementLoaded(By selector) {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void switchTab(int tabNumber) {
        List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(browserTabs.get(tabNumber));

        waitElementLoaded(By.cssSelector("body"));
    }
}
