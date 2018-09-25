package com.ilgonmic.horoscope.element;

import com.ilgonmic.horoscope.data.NamedEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

import static com.ilgonmic.horoscope.tool.WaitTools.waitForCondition;
import static java.util.function.Function.identity;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;

@Component(xpath = "//*[contains(@class, 'filter__list')]")
public class Filter extends ComponentObject {

    private final String filterTabLocator = "//span[contains(@class, 'filter__item')][.//span[@class='filter__text'][text()='%s']]";

    public Filter(WebDriver driver) {
        super(driver);
    }

    public boolean isFilterTabActive(NamedEnum tab) {
        return isFilterTabInCondition(tab, identity());
    }

    public boolean isFilterTabNotActive(NamedEnum tab) {
        return isFilterTabInCondition(tab, ExpectedConditions::not);
    }

    public void clickFilterTab(NamedEnum tab) {
        String locator = String.format(filterTabLocator, tab.getName());
        getDriver().findElement(By.xpath(locator)).click();
    }

    private <T> boolean isFilterTabInCondition(NamedEnum tab,
                                               Function<ExpectedCondition<Boolean>, ExpectedCondition<T>> condition) {
        String locator = String.format(filterTabLocator, tab.getName());

        return waitForCondition(
                getDriver(),
                condition.apply(
                        attributeContains(By.xpath(locator),
                                "class",
                                "filter__item_active")
                )
        );
    }
}
