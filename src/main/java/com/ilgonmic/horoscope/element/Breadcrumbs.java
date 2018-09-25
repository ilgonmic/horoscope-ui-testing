package com.ilgonmic.horoscope.element;

import com.ilgonmic.horoscope.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component(xpath = "//div[contains(@class, 'breadcrumbs')]")
public class Breadcrumbs extends AbstractPage {

    private final String breadcrumbLinkLocator = "//a[contains(@class, 'breadcrumbs__link')]";

    public Breadcrumbs(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllBreadcrumbsTitles() {
        return getDriver().findElements(By.xpath(breadcrumbLinkLocator)).stream()
                .map(WebElement::getText)
                .collect(toList());
    }

    public void clickBreadcrumbLink(int index) {
        List<WebElement> elements = getDriver().findElements(By.xpath(breadcrumbLinkLocator));
        elements.get(index).click();
    }
}