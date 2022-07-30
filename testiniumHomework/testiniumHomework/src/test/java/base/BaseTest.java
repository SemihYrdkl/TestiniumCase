package base;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    static WebDriver webDriver = null;
    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C://Users//semih//Desktop//Testinium//testiniumHomework//testiniumHomework//properties//drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(options));
        getWebDriver().navigate().to("https://www.kitapyurdu.com/");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
    public static void setWebDriver(WebDriver webDriver){
        BaseTest.webDriver = webDriver;
    }
    public static WebDriver getWebDriver(){
        return webDriver;
    }


}
