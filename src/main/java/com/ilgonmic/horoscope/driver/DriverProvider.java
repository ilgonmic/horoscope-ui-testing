package com.ilgonmic.horoscope.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProvider {

    private WebDriver driver;

    public DriverProvider() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(
                "--headless",
                "--disable-gpu",
                "--no-sandbox",
                "--no-first-run",
                "--homepage=about:blank",
                "--ignore-certificate-errors"
        );

        driver = new ChromeDriver(chromeOptions);
    }

    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}