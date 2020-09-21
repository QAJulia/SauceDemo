package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {

    public static final By ITEM_NAME = By.cssSelector(".inventory_item_name");
    public static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action.checkout_button");
    public static final By CONTINUE_SHOPPING = By.xpath("//*[contains(text(),'Continue Shopping')]");
    public static final By OPEN_MENU = By.xpath("//button[text()='Open Menu']");
    public static final By CLOSE_MENU = By.xpath("//button[text()='Close Menu']");
    public static final By ITEM_MENU = By.id("inventory_sidebar_link");
    String productLocator = "//*[contains(text(),'%s')]/" +
            "ancestor::div[@class='cart_item']//*[text()='REMOVE']";

    public CartPage(WebDriver driver) { super(driver); }

    public CartPage isPageOpened() {
        Assert.assertTrue(driver.findElement(CHECKOUT_BUTTON).isDisplayed());;
        return this;
    }

    public CartPage openPage(){
        driver.get("https://www.saucedemo.com/cart.html");
        isPageOpened();
        return this;
    }

    public String productInTheList(){
        return driver.findElement(ITEM_NAME).getText();
    }

    public int sizeOfCartList(){
        List<WebElement> elements = driver.findElements(ITEM_NAME);
        return elements.size();
    }

    public CartPage removeProduct(String productName){
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
        return this;
    }

    public ProductsPage allItems(){
        driver.findElement(ITEM_MENU).click();
        return new ProductsPage(driver);
    }

    public ProductsPage continueShopping(){
        driver.findElement(CONTINUE_SHOPPING).click();
        return new ProductsPage(driver);
    }

    public CheckoutPage checkOut(){
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }

    public CartPage refreshPage(){
        driver.navigate().refresh();
        return this;
    }

    public CartPage resetAppState(){
        driver.findElement(RESET_APP_STATE).click();
        return this;
    }

    public CartPage openMenu(){
        driver.findElement(OPEN_MENU).click();
        return this;
    }

    public CartPage closeMenu(){
        driver.findElement(CLOSE_MENU).click();
        return this;
    }
}
