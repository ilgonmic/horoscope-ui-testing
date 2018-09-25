package com.ilgonmic.horoscope.step;

import com.ilgonmic.horoscope.page.PageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps extends PageObject {

    public AbstractSteps(WebDriver driver) {
        super(driver);
    }
}
