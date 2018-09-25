package com.ilgonmic.horoscope.step.page;

import com.ilgonmic.horoscope.page.AlgizRunePage;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AlgizRunePageSteps extends AbstractSteps {

    private AlgizRunePage algizRunePage;

    public AlgizRunePageSteps(WebDriver driver) {
        super(driver);
        algizRunePage = PageFactory.initElements(driver, AlgizRunePage.class);
    }

    @Step("Open Algiz rune page")
    public void open() {
        algizRunePage.open();
        algizRunePage.pageValidate();
    }
}
