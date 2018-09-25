package com.ilgonmic.horoscope.element;

import com.ilgonmic.horoscope.page.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.ilgonmic.horoscope.tool.WaitTools.waitForCondition;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public abstract class ComponentObject extends PageObject {

    {
        componentValidate();
    }

    public ComponentObject(WebDriver driver) {
        super(driver);
    }

    private void componentValidate() {
        Class<?> componentClass = getClass();
        if (componentClass.isAnnotationPresent(Component.class)) {
            Component component = componentClass.getAnnotation(Component.class);

            assertTrue("Component " + componentClass.getName() + " absents on page",
                    waitForCondition(getDriver(), presenceOfElementLocated(By.xpath(component.xpath()))));
        }
    }
}