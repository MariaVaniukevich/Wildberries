package org.aston;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage {
    public WebDriver driver;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//span[@class = 'good-info__good-name'])[1]")
    public WebElement productName1;

    @FindBy(xpath = "(//span[@class = 'good-info__good-name'])[2]")
    public WebElement productName2;

    @FindBy(xpath = "(//span[@class = 'good-info__good-name'])[3]")
    public WebElement productName3;

    @FindBy(xpath = "//span[@class = 'good-info__good-name']")
    public List<WebElement> productList;

    @FindBy(xpath = "(//div[@class = 'list-item__price-new'])[1]")
    public WebElement productPrice1;

    @FindBy(xpath = "(//div[@class = 'list-item__price-new'])[2]")
    public WebElement productPrice2;

    @FindBy(xpath = "(//div[@class = 'list-item__price-new'])[3]")
    public WebElement productPrice3;

    @FindBy(xpath = "(//p[@class = 'b-top__total line']//span)[2]")
    public WebElement sumPrice;
}