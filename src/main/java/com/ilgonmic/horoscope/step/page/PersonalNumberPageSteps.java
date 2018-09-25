package com.ilgonmic.horoscope.step.page;

import com.ilgonmic.horoscope.page.PersonalNumberPage;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PersonalNumberPageSteps extends AbstractSteps {

    private PersonalNumberPage personalNumberPage;

    public PersonalNumberPageSteps(WebDriver driver) {
        super(driver);
        personalNumberPage = PageFactory.initElements(driver, PersonalNumberPage.class);
    }

    @Step("Open Personal Number page")
    public void open() {
        personalNumberPage.open();
        personalNumberPage.pageValidate();
    }
}
