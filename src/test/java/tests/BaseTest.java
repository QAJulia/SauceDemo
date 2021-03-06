package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    public final static String USERNAME = "standard_user";
    public final static String PASSWORD = "secret_sauce";
    public final static String FIRST_NAME = "Julia";
    public final static String LAST_NAME = "Petrova";
    public final static String ZIP = "12345";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
