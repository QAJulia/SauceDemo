package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_INPUT = By.id("postal-code");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    public static final By SAUCE_CARD = By.cssSelector(".summary_info_label");
    public static final By ERROR_MESSAGE = By.cssSelector("*[data-test='error']");
    public static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");
    public static final By FINISH_TEXT = By.id("checkout_complete_container");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void informationCheckout(String firstName, String lastName, String zip){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_INPUT).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String checkoutPageUniqueLocator(){
        return driver.findElement(SAUCE_CARD).getTagName();
    }

    public String getErrorMessage(){
        return  driver.findElement(ERROR_MESSAGE).getText();
    }

    public void finishOrder(){
        driver.findElement(FINISH_BUTTON).click();
    }

    public String finishPageUniqueLocator(){
        return driver.findElement(FINISH_TEXT).getTagName();
    }
}
