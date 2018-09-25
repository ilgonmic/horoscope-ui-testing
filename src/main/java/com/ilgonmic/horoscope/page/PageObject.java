package com.ilgonmic.horoscope.page;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public abstract class PageObject {

    private static final String WEBDRIVER_BASE_URL = "webdriver.base.url";
    private WebDriver driver;

    private Class<?> pageClass;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.pageClass = getClass();
    }

    public void pageValidate() {
        if (pageClass.isAnnotationPresent(UrlPattern.class)) {
            String pattern = pageClass.getAnnotation(UrlPattern.class).value();
            assertTrue("Actual URI doesn't consist with expected pattern " + pattern,
                    driver.getCurrentUrl().matches("http[s]?.*?(?::\\d+)?/" + pattern + "/?"));
        }
    }

    String getPageUrl() {
        if (pageClass.isAnnotationPresent(Page.class)) {
            return System.getProperty(WEBDRIVER_BASE_URL) + pageClass.getAnnotation(Page.class).value();
        }

        return "";
    }

    protected WebDriver getDriver() {
        return driver;
    }
}