package base;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions ;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import test.MainTest;

import java.util.List;
import java.util.Random;


import static constants.HomePageLocators.searchTextbox;

public class BasePage {
    WebDriver driver = null;
    WebDriverWait wait = null;
    private static Logger logger = LoggerFactory.getLogger(BasePage.class);


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }
    public void sendKeys (By by, String text) {

        findElement(by). sendKeys (text);
    }
    public void clicksendKeys () {
        findElement(searchTextbox).sendKeys(Keys.ENTER);
    }
    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void clear(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).clear();
    }

    public String getText(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }
    /*
    public void clickRandomElementWithBy(By by) {
        List<WebElement> elementList = findElements(by);
        Random rand = new Random();
        WebElement element = elementList.get(rand.nextInt(elementList.size()));
        element.click();
      //  logger.info(by + " listesinden random bir elemente tıklandı.");
    }
    */



}
