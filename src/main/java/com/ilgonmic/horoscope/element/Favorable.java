package com.ilgonmic.horoscope.element;

import com.ilgonmic.horoscope.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Component(xpath = "//div[contains(@class, 'favorable')]")
public class Favorable extends AbstractPage {

    private final String favorableLinkLocator = "//div[contains(@class, 'p-favorable__item')][1]/a[contains(@class, 'p-favorable__item__value')]";

    public Favorable(WebDriver driver) {
        super(driver);
    }

    public String getFavorableSign() {
        return getDriver()
                .findElement(By.xpath(favorableLinkLocator))
                .findElement(By.xpath(".//span[contains(@class, 'link__text')]"))
                .getText();
    }

    public void clickFavorableLink() {
        getDriver().findElement(By.xpath(favorableLinkLocator))
                .click();
    }
}