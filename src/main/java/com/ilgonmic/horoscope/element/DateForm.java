package com.ilgonmic.horoscope.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Component(xpath = "//div[contains(@class, 'p-tooltip_active')]/descendant::div[contains(@class, 'p-tooltip__inner')]")
public class DateForm extends ComponentObject {

    private final String textInputLocator = "//div[contains(@class, 'p-tooltip_active')]/descendant::div[contains(@class, 'dropdown__text')][%d]";

    private final String saveButtonLocator = "//div[contains(@class, 'p-tooltip_active')]/descendant::button";

    public DateForm(WebDriver driver) {
        super(driver);
    }

    public String getTextInput(int index) {
        return getDriver()
                .findElement(By.xpath(String.format(textInputLocator, index)))
                .getText();
    }

    public void clickSaveButton() {
        getDriver().findElement(By.xpath(saveButtonLocator)).click();
    }
}
