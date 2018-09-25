package com.ilgonmic.horoscope.step.element;

import com.ilgonmic.horoscope.element.DateForm;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

@DisplayName("Favorable step")
public class DateFormElementSteps extends AbstractSteps {

    private DateForm dateFormElement;

    public DateFormElementSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Check default input in {index} field, {expected} expected")
    public void checkDefaultInput(String expected, int index) {
        Assert.assertEquals("Incorrect default " + index + " field, expected " + expected,
                expected,
                getDateFormElement().getTextInput(index));
    }

    @Step("Click save button")
    public void clickSaveButton() {
        getDateFormElement().clickSaveButton();
    }

    private DateForm getDateFormElement() {
        if (dateFormElement == null) {
            dateFormElement = initElements(getDriver(), DateForm.class);
        }

        return dateFormElement;
    }
}