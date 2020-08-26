package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    public static final By ITEM_NAME = By.cssSelector(".inventory_item_name");
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action.checkout_button");
    public static final By CONTINUE_SHOPPING = By.xpath("//*[contains(text(),'Continue Shopping')]");
    String productLocator = "//*[contains(text(),'%s')]/" +
            "ancestor::div[@class='cart_item']//*[text()='REMOVE']";

    public CartPage(WebDriver driver) { super(driver); }

    public void openPage(){
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public String productInTheList(){
        return driver.findElement(ITEM_NAME).getText();
    }

    public int sizeOfCartList(){
        List<WebElement> elements = driver.findElements(ITEM_NAME);
        return elements.size();
    }

    public void removeProduct(String productName){
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
    }

    public void continueShopping(){
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public void checkOut(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
