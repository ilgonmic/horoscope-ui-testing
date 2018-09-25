package com.ilgonmic.horoscope.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends PageObject {

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get(getPageUrl());
    }

    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) getDriver();
    }
}
