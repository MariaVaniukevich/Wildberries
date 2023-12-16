import org.aston.BasketPage;
import org.aston.CatalogPage;
import org.aston.StartPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WbTest {
    public static WebDriver driver;
    public static BasketPage basketPage;
    public static StartPage startPage;
    public static CatalogPage catalogPage;
    public static WebDriverWait webDriverWait;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.wildberries.ru/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        basketPage = new BasketPage(driver);
        startPage = new StartPage(driver);
        catalogPage = new CatalogPage(driver);
    }

    @Test
    public void wbTest() throws InterruptedException {
        startPage.moveToSearch();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 100);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class = 'product-card__link j-card-link j-open-full-product-card'])[1]")));
        catalogPage.moveToProduct1();
        catalogPage.addProduct1();
        catalogPage.moveToProduct2();
        catalogPage.addProduct2();
        catalogPage.moveToProduct3();
        catalogPage.addProduct3();
        Thread.sleep(5000);
        catalogPage.moveToBasket();

        assertEquals("Гирлянда нить на елку 9 метров", basketPage.productName1.getText());
        assertEquals("Гирлянда шарики тканевые интерьерные", basketPage.productName2.getText());
        assertEquals("Гирлянда шарики новогодняя на елку", basketPage.productName3.getText());

        assertEquals(3, basketPage.productList.size());

        assertEquals("390 ₽", basketPage.productPrice1.getText());
        assertEquals("399 ₽", basketPage.productPrice2.getText());
        assertEquals("475 ₽", basketPage.productPrice3.getText());

        assertEquals("1 264 ₽", basketPage.sumPrice.getText());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
