package com.ilgonmic.horoscope.page;

import org.openqa.selenium.WebDriver;

@Page("/numerology/chislovaya-vibraciya-imen/")
@UrlPattern("numerology/chislovaya-vibraciya-imen")
public class NumberVibrationNamePage extends AbstractPage {
    public NumberVibrationNamePage(WebDriver driver) {
        super(driver);
    }
}