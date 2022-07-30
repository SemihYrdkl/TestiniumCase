
package test;

import base.BasePage;
import base.BaseTest;


import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import page.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.Scanner;


public class MainTest extends BaseTest{
    HomePage homepage;
    BasketPage basketPage;
    public static String testDataline;
    private static Log4jLoggerAdapter logger = (Log4jLoggerAdapter) LoggerFactory.getLogger(BaseTest.class);

    @Before
    public void before() {
        homepage = new HomePage(getWebDriver());
        basketPage = new BasketPage(getWebDriver());
    }

    @Test
    public void test() throws InterruptedException, FileNotFoundException {
        Assert.assertEquals("Kitapyurdu, Kitapla buluşmanın en kolay yolu", getWebDriver().getTitle());
        logger.info("Anasayfanın açıldığı kontrol edilir.");
        Scanner data = new Scanner(new File("src/data/TestData.csv"));
        testDataline = data.nextLine();
        homepage.sendText(testDataline).clicksendKeys();
        homepage.ClickAddToBasket();
        Thread.sleep(4000);
        Assert.assertEquals(homepage.getBasketCount(),"1");
        logger.info("Sepetteki ürün sayısının 1 olduğu görülür.");
        homepage.myBasketButton();
        homepage.GoToMyBasket();
        basketPage.clearQuantity();
        basketPage.raiseQuantity();
        basketPage.clickRefreshButton();
        Assert.assertEquals(basketPage.getUpdateBasketText(),"Sepetiniz güncelleniyor!");
        logger.info("Sepetiniz güncelleniyor yazısı görülür.");
        basketPage.removeAllProduct();
        Thread.sleep(3000);
        Assert.assertEquals(basketPage.getUpdateBasketText(),"Sepetinizden çıkarılıyor!");
        logger.info("Sepetinizden çıkarılıyor yazısı görülür.");
        Thread.sleep(3000);
    }
}










