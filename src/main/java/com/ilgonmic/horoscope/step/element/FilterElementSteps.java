package com.ilgonmic.horoscope.step.element;

import com.ilgonmic.horoscope.data.NamedEnum;
import com.ilgonmic.horoscope.element.Filter;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

@DisplayName("Filter step")
public class FilterElementSteps extends AbstractSteps {

    private Filter filterElement;

    public FilterElementSteps(WebDriver driver) {
        super(driver);
    }

    private Filter getFilterElement() {
        if (filterElement == null) filterElement = PageFactory.initElements(getDriver(), Filter.class);
        return filterElement;
    }

    @Step("Check, that tab {tab.getName} is active in filter")
    public void filterTabShouldBeActive(NamedEnum tab) {
        assertTrue("Tab of filter " + tab.getName() + " should be active",
                getFilterElement().isFilterTabActive(tab));
    }

    @Step("Check, that tab {tab.getName} isn't active in filter")
    public void filterTabShouldNotBeActive(NamedEnum tab) {
        assertTrue("Tab of filter " + tab.getName() + " shouldn't be active",
                getFilterElement().isFilterTabNotActive(tab));
    }

    @Step("Click tab {tab.getName}")
    public void clickFilterTab(NamedEnum tab) {
        getFilterElement().clickFilterTab(tab);
    }
}