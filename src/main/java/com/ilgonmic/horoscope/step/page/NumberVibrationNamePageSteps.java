package com.ilgonmic.horoscope.step.page;

import com.ilgonmic.horoscope.page.NumberVibrationNamePage;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NumberVibrationNamePageSteps extends AbstractSteps {

    private NumberVibrationNamePage numberVibrationNamePage;

    public NumberVibrationNamePageSteps(WebDriver driver) {
        super(driver);
        numberVibrationNamePage = PageFactory.initElements(driver, NumberVibrationNamePage.class);
    }

    @Step("Open Number Vibration Name page")
    public void open() {
        numberVibrationNamePage.open();
        numberVibrationNamePage.pageValidate();
    }
}
