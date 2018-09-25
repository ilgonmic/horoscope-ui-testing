package com.ilgonmic.horoscope.page;

import org.openqa.selenium.WebDriver;

@Page("/runes/tile/15/")
@UrlPattern("runes/tile/15")
public class AlgizRunePage extends AbstractPage {
    public AlgizRunePage(WebDriver driver) {
        super(driver);
    }
}