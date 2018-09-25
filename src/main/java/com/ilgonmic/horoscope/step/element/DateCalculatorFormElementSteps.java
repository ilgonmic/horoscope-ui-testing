package com.ilgonmic.horoscope.step.element;

import com.ilgonmic.horoscope.element.DateCalculatorForm;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

@DisplayName("Favorable step")
public class DateCalculatorFormElementSteps extends AbstractSteps {

    private DateCalculatorForm dateCalculatorFormElement;

    public DateCalculatorFormElementSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Click birthday link")
    public void clickBirthdayLink() {
        getDateCalculatorFormElement().clickBirthdayLink();
    }

    @Step("Click date link")
    public void clickDateLink() {
        getDateCalculatorFormElement().clickDateLink();
    }

    private DateCalculatorForm getDateCalculatorFormElement() {
        if (dateCalculatorFormElement == null) {
            dateCalculatorFormElement = initElements(getDriver(), DateCalculatorForm.class);
        }

        return dateCalculatorFormElement;
    }
}