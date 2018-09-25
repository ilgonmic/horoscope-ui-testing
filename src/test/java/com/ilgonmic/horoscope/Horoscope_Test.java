package com.ilgonmic.horoscope;

import com.ilgonmic.horoscope.data.NumberVibrationNumberTab;
import com.ilgonmic.horoscope.data.PersonalNumberTab;
import com.ilgonmic.horoscope.driver.DriverProvider;
import com.ilgonmic.horoscope.step.element.*;
import com.ilgonmic.horoscope.step.page.AlgizRunePageSteps;
import com.ilgonmic.horoscope.step.page.NumberVibrationNamePageSteps;
import com.ilgonmic.horoscope.step.page.PersonalNumberPageSteps;
import io.qameta.allure.Severity;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;

import static com.google.common.base.Predicates.equalTo;
import static com.google.common.base.Predicates.not;
import static com.ilgonmic.horoscope.data.NumberVibrationNumberTab.WORLD;
import static com.ilgonmic.horoscope.data.PersonalNumberTab.MONTH;
import static com.ilgonmic.horoscope.tool.WaitTools.waitForCondition;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static java.util.Arrays.stream;
import static java.util.Calendar.YEAR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class Horoscope_Test {

    private DriverProvider driverProvider;

    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @After
    public void closeDriver() {
        driverProvider.close();
    }

    @Ignore
    @Test
    @Severity(BLOCKER)
    public void check_personal_number_defaults() {
        WebDriver driver = driverProvider.getDriver();

        PersonalNumberPageSteps personalNumberPageSteps = new PersonalNumberPageSteps(driver);
        personalNumberPageSteps.open();

        FilterElementSteps filterElementSteps = new FilterElementSteps(driver);
        filterElementSteps.clickFilterTab(MONTH);

        filterElementSteps.filterTabShouldBeActive(MONTH);

        //noinspection Guava
        stream(PersonalNumberTab.values())
                .filter(not(equalTo(MONTH)))
                .forEach(filterElementSteps::filterTabShouldNotBeActive);

        DateCalculatorFormElementSteps dateCalculatorFormElementSteps = new DateCalculatorFormElementSteps(driver);
        dateCalculatorFormElementSteps.clickDateLink();

        DateFormElementSteps dateFormElementSteps = new DateFormElementSteps(driver);
        dateFormElementSteps.checkDefaultInput("январь", 1);
        dateFormElementSteps.checkDefaultInput(String.valueOf(Calendar.getInstance().get(YEAR)), 2);
        dateFormElementSteps.clickSaveButton();
    }

    @Ignore
    @Test
    @Severity(BLOCKER)
    public void empty_actions_number_vibration_name() {
        WebDriver driver = driverProvider.getDriver();

        NumberVibrationNamePageSteps numberVibrationNamePageSteps = new NumberVibrationNamePageSteps(driver);

        numberVibrationNamePageSteps.open();

        FilterElementSteps filterElementSteps = new FilterElementSteps(driver);
        filterElementSteps.filterTabShouldBeActive(WORLD);

        //noinspection Guava
        stream(NumberVibrationNumberTab.values())
                .filter(not(equalTo(WORLD)))
                .forEach(filterElementSteps::filterTabShouldNotBeActive);

        InputCalculatorFormElementSteps
                inputCalculatorFormElementSteps = new InputCalculatorFormElementSteps(driver);
        inputCalculatorFormElementSteps.checkInputValueEmpty();

        String urlBeforeClick = driver.getCurrentUrl();
        inputCalculatorFormElementSteps.clickButton();

        assertEquals("URL should not be changed", urlBeforeClick, driver.getCurrentUrl());
    }

    @Test
    @Severity(BLOCKER)
    public void click_rune_breadcrumb_link() {
        WebDriver driver = driverProvider.getDriver();

        AlgizRunePageSteps algizRunePageSteps = new AlgizRunePageSteps(driver);

        algizRunePageSteps.open();

        BreadcrumbsElementSteps breadcrumbsElementSteps = new BreadcrumbsElementSteps(driver);
        breadcrumbsElementSteps.breadcrumbsContainsSomeLinks(1);

        breadcrumbsElementSteps.clickBreadcrumb(0);

        assertEquals("Breadcrumb click not direct to expected page",
                "https://horo.mail.ru/runes/tile/",
                driver.getCurrentUrl());

        assertTrue("Title is incorrect",
                waitForCondition(driver, titleContains("Описание набора Рун")));
    }

    @Test
    @Severity(BLOCKER)
    public void click_rune_favorable_link() {
        WebDriver driver = driverProvider.getDriver();

        AlgizRunePageSteps algizRunePageSteps = new AlgizRunePageSteps(driver);

        algizRunePageSteps.open();

        FavorableElementSteps favorableElementSteps = new FavorableElementSteps(driver);
        favorableElementSteps.checkFavorableSign();

        favorableElementSteps.clickFavorable();

        assertEquals("Breadcrumb click not direct to expected page",
                "https://horo.mail.ru/horoscope/zodiac/cancer/",
                driver.getCurrentUrl());

        assertTrue("Title is incorrect",
                waitForCondition(driver, titleContains("Рак")));
    }
}