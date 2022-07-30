package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;

import static constants.BasketPageLocators.*;
import static constants.HomePageLocators.searchTextbox;


public class BasketPage extends BasePage {
    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }
   public String getUpdateBasketText(){
        return findElement(updateBasketText).getText();
    }
    public BasketPage clickRefreshButton() {
        click(refreshButton);
        return this;
    }
    public BasketPage raiseQuantity(){
        sendKeys(quantity, "2");
        return this;
    }
    public BasketPage clearQuantity(){
       clear(quantity);
        return this;
    }
    public BasketPage removeAllProduct () {
        click(deleteBasket);
        return this;
    }
}
