package page;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

import static constants.HomePageLocators.*;
public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public String getBasketCount(){
        return findElement(basketArea).getText();
    }
    public HomePage ClickSearch() {
        click(searchTextbox);
        return this;
    }
    public HomePage sendText(String value){
        sendKeys(searchTextbox, value);
        return this;
    }
    public HomePage ClickAddToBasket(){
        click(addToBasket);
        return this;
    }
   public HomePage myBasketButton(){
        click(basketArea);
        return this;
    }
    public HomePage GoToMyBasket(){
        click(goToMyBasket);
        return this;
    }
}
