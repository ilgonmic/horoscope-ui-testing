package com.ilgonmic.horoscope.step.element;

import com.ilgonmic.horoscope.element.Favorable;
import com.ilgonmic.horoscope.step.AbstractSteps;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.PageFactory.initElements;

@DisplayName("Favorable step")
public class FavorableElementSteps extends AbstractSteps {

    private Favorable favorableElement;

    public FavorableElementSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Check favorable sign")
    public void checkFavorableSign() {
        assertEquals("Incorrect favorable sign name",
                "Рак",
                getFavorableElement().getFavorableSign());
    }

    @Step("Click on favorable link")
    public void clickFavorable() {
        getFavorableElement().clickFavorableLink();
    }

    private Favorable getFavorableElement() {
        if (favorableElement == null) {
            favorableElement = initElements(getDriver(), Favorable.class);
        }

        return favorableElement;
    }
}