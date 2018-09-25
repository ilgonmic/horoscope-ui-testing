package com.ilgonmic.horoscope.tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Long.parseLong;
import static java.lang.System.getProperty;

public final class WaitTools {

    private static final String WEBDRIVER_TIMEOUTS_IMPLICITLYWAIT = "webdriver.timeouts.implicitlywait";

    private WaitTools() {
    }

    public static <T> boolean waitForCondition(WebDriver driver, ExpectedCondition<T> condition) {
        return waitForCondition(driver,
                condition,
                parseLong(getProperty(WEBDRIVER_TIMEOUTS_IMPLICITLYWAIT)) / 1000);
    }

    public static <T> boolean waitForCondition(WebDriver driver,
                                               ExpectedCondition<T> condition,
                                               long timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(driver,
                timeout);

        try {
            webDriverWait.until(condition);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}