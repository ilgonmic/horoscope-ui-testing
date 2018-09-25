package com.ilgonmic.horoscope.step.element;

import com.ilgonmic.horoscope.element.InputCalculatorForm;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.PageFactory.initElements;

@DisplayName("Favorable step")
public class InputCalculatorFormElementSteps extends AbstractSteps {

    private InputCalculatorForm inputCalculatorFormElement;

    public InputCalculatorFormElementSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Check input value is empty")
    public void checkInputValueEmpty() {
        assertTrue("Input value should be empty",
                getInputCalculatorFormElement().isEmptyInputValue());
    }

    @Step("Click button")
    public void clickButton() {
        getInputCalculatorFormElement().clickButton();
    }

    private InputCalculatorForm getInputCalculatorFormElement() {
        if (inputCalculatorFormElement == null) {
            inputCalculatorFormElement = initElements(getDriver(), InputCalculatorForm.class);
        }

        return inputCalculatorFormElement;
    }
}