package org.aston;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {
    public WebDriver driver;
    Actions builder;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        builder = new Actions(this.driver);
    }

    @FindBy(xpath = "(//*[@class = 'product-card__link j-card-link j-open-full-product-card'])[1]")
    public WebElement product1;

    @FindBy(xpath = "(//*[@class = 'product-card__add-basket j-add-to-basket btn-main-sm-2'])[1]")
    public WebElement productBasket1;

    @FindBy(xpath = "(//*[@class = 'product-card__link j-card-link j-open-full-product-card'])[2]")
    public WebElement product2;

    @FindBy(xpath = "(//*[@class = 'product-card__add-basket j-add-to-basket btn-main-sm-2'])[1]")
    public WebElement productBasket2;

    @FindBy(xpath = "(//*[@class = 'product-card__link j-card-link j-open-full-product-card'])[3]")
    public WebElement product3;

    @FindBy(xpath = "(//*[@class = 'product-card__add-basket j-add-to-basket btn-main-sm-2'])[1]")
    public WebElement productBasket3;

    @FindBy(xpath = "//*[@class = 'navbar-pc__icon navbar-pc__icon--basket']")
    public WebElement basketBtn;

    public void moveToProduct1() {
        builder.moveToElement(product1).perform();
    }

    public void moveToProduct2() {
        builder.moveToElement(product2).perform();
    }

    public void moveToProduct3() {
        builder.moveToElement(product3).perform();
    }

    public void addProduct1() {
        productBasket1.click();
    }

    public void addProduct2() {
        productBasket2.click();
    }

    public void addProduct3() {
        productBasket3.click();
    }

    public void moveToBasket() {
        basketBtn.click();
    }
}