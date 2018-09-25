package com.ilgonmic.horoscope.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Component(xpath = "/descendant::div[contains(@class, 'p-tabs__item_active')][1]")
public class DateCalculatorForm extends ComponentObject {

    private final String birthdayLinkLocator = "/descendant::div[contains(@class, 'p-tabs__item_active')][1]/descendant::div[contains(@class, 'p-formitem__content')][1]/descendant::a";
    private final String dateLinkLocator = "/descendant::div[contains(@class, 'p-tabs__item_active')][1]/descendant::div[contains(@class, 'p-formitem__content')][2]/descendant::a";

    private final String calculateButtonLocator = "/descendant::div[contains(@class, 'p-tabs__item_active')][1]/descendant::button[not(contains(@class, 'js-date-select__save'))]";

    public DateCalculatorForm(WebDriver driver) {
        super(driver);
    }

    public void clickBirthdayLink() {
        clickByLocator(birthdayLinkLocator);
    }

    public void clickDateLink() {
        clickByLocator(dateLinkLocator);
    }

    private void clickByLocator(String locator) {
        getDriver().findElement(By.xpath(locator)).click();
    }
}
