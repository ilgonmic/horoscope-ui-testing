package com.ilgonmic.horoscope.step.element;

import com.ilgonmic.horoscope.element.Breadcrumbs;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.PageFactory.initElements;

@DisplayName("Breadcrumbs step")
public class BreadcrumbsElementSteps extends AbstractSteps {

    private Breadcrumbs breadcrumbsElement;

    public BreadcrumbsElementSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Check breadcrumbs contains only {expectedCount} link")
    public void breadcrumbsContainsSomeLinks(int expectedCount) {
        assertEquals("Breadcrumbs should contain only " + expectedCount + " link",
                expectedCount, getBreadcrumbsElement().getAllBreadcrumbsTitles().size());
    }

    @Step("Click on {index} breadcrumb")
    public void clickBreadcrumb(int index) {
        getBreadcrumbsElement().clickBreadcrumbLink(index);
    }

    private Breadcrumbs getBreadcrumbsElement() {
        if (breadcrumbsElement == null) {
            breadcrumbsElement = initElements(getDriver(), Breadcrumbs.class);
        }

        return breadcrumbsElement;
    }
}