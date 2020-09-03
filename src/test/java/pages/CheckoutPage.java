package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage{

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_INPUT = By.id("postal-code");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    public static final By LOCATOR = By.cssSelector(".subheader");
    public static final By ERROR_MESSAGE = By.cssSelector("*[data-test='error']");
    public static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");
    public static final By FINISH_TEXT = By.id("checkout_complete_container");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR));
        Assert.assertTrue(driver.findElement(LOCATOR).isDisplayed());
        return this;
    }

    public CheckoutPage openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        isPageOpened();
        return this;
    }

    public CheckoutPage openSecondCheckoutPage(){
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        isPageOpened();
        return this;
    }

    public CheckoutPage isSecondCheckoutPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_BUTTON));
        Assert.assertTrue(driver.findElement(FINISH_BUTTON).isDisplayed());
        return this;
    }

    public CheckoutPage informationOnCheckoutPage(String firstName, String lastName, String zip){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_INPUT).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public CheckoutPage wrongInformationOnCheckoutPage(String firstName, String lastName, String zip){
        informationOnCheckoutPage(firstName, lastName, zip);
        return this;
    }

    public String getErrorMessage(){
        return  driver.findElement(ERROR_MESSAGE).getText();
    }

    public CheckoutPage completeCheckout(){
        driver.findElement(FINISH_BUTTON).click();
        return this;
    }

    public CheckoutPage isFinishPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_TEXT));
        Assert.assertTrue(driver.findElement(FINISH_TEXT).isDisplayed());
        return this;
    }
}