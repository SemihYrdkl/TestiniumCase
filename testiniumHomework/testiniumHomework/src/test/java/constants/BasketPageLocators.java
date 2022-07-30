package constants;
import org.openqa.selenium.By;


public class BasketPageLocators {

    public static final By quantity = By.name("quantity");
    public static final By refreshButton = By.xpath("//i[@title='Güncelle']");
    public static final By updateBasketText = By.id("swal2-title");
    public static final By deleteBasket = By.xpath("//i[@title='Kaldır']");
}
