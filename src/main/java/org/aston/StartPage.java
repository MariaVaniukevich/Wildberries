package org.aston;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    public WebDriver driver;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class = 'search-catalog__input j-wba-header-item']")
    private WebElement searchCatalog;

    public void moveToSearch() {
        searchCatalog.sendKeys("гирлянда малиновая занавес шарики" + Keys.ENTER);
    }
}