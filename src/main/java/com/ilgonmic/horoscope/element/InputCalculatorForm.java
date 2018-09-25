package com.ilgonmic.horoscope.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Component(xpath = "/descendant::div[contains(@class, 'p-tabs__item_active')][1]")
public class InputCalculatorForm extends ComponentObject {

    private final String inputLocator = "/descendant::div[contains(@class, 'p-tabs__item_active')][1]/descendant::input";
    private final String buttonLocator = "/descendant::div[contains(@class, 'p-tabs__item_active')][1]/descendant::button";

    public InputCalculatorForm(WebDriver driver) {
        super(driver);
    }

    public boolean isEmptyInputValue() {
        return getInputValue().isEmpty();
    }

    public void clickButton() {
        getDriver().findElement(By.xpath(buttonLocator)).click();
    }

    private String getInputValue() {
        return getDriver().findElement(By.xpath(inputLocator)).getAttribute("value");
    }
}
