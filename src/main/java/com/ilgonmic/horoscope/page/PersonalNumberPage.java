package com.ilgonmic.horoscope.page;

import org.openqa.selenium.WebDriver;

@Page("/numerology/personalnoe-chislo-dnya-mesyaca-goda/")
@UrlPattern("numerology/personalnoe-chislo-dnya-mesyaca-goda")
public class PersonalNumberPage extends AbstractPage {
    public PersonalNumberPage(WebDriver driver) {
        super(driver);
    }
}