package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage{

    String productLocator = "//*[contains(text(),'%s')]/" +
            "ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    String nameOfTheProduct = "//*[contains(text(), '%s')]";
    public static final By PRODUCT_SORT = By.cssSelector(".product_sort_container");
    public static final By INVENTORY_ITEM = By.cssSelector(".inventory_item");
    public static final By INVENTORY_ITEM_NAME = By.cssSelector(".inventory_item_name");
    public static final By INVENTORY_ITEM_PRICE= By.cssSelector(".inventory_item_price");
    public static final By SHOPPING_CART_ICON = By.xpath("//*[@id = 'shopping_cart_container']/a");
    public static final By OPEN_MENU = By.xpath("//button[text()='Open Menu']");
    public static final By CLOSE_MENU = By.xpath("//button[text()='Close Menu']");
    public static final By ITEM_MENU = By.id("inventory_sidebar_link");
    public static final By ABOUT = By.id("about_sidebar_link");
    public static final By LOGOUT = By.id("logout_sidebar_link");
    public static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    public static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn_primary.btn_inventory");
    public static final By REMOVE_BUTTON = By.cssSelector(".btn_secondary.btn_inventory");
    public static final By INVENTORY_DETAILS_NAME = By.cssSelector(".inventory_details_name");
    public static final By INVENTORY_DETAILS_PRICE = By.cssSelector(".inventory_details_price");
    public static final By BACK_BUTTON = By.cssSelector(".inventory_details_back_button");
    public static final By UNIQUE_LOCATOR = By.cssSelector(".product_label");

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public ProductsPage openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        isPageOpened();
        return this;
    }

    public ProductsPage isPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(UNIQUE_LOCATOR));
        Assert.assertTrue(driver.findElement(UNIQUE_LOCATOR).isDisplayed());
        return this;
    }

    public ProductsPage addProduct(String productName){
        driver.findElement(By.xpath(String.format(productLocator, productName))).click();
        return this;
    }

    public String sortProducts(String value){
        Select select= new Select(driver.findElement(PRODUCT_SORT));
        select.selectByValue(value);
        List<WebElement> elements = driver.findElements(INVENTORY_ITEM);
        return elements.get(0).findElement(INVENTORY_ITEM_NAME).getText();
    }

    public ProductsPage displayInformationAboutProduct(String product){
        driver.findElement(By.xpath(String.format(nameOfTheProduct, product))).click();
        System.out.println(driver.findElement(INVENTORY_DETAILS_NAME).getText() + ": " + driver.findElement(INVENTORY_DETAILS_PRICE).getText());
        driver.findElement(BACK_BUTTON).click();
        return this;
    }

    public ProductsPage openMenu(){
        driver.findElement(OPEN_MENU).click();
        return this;
    }

    public ProductsPage closeMenu(){
        driver.findElement(CLOSE_MENU).click();
        return this;
    }

    public boolean isAboutPageOpened(){
        driver.findElement(ABOUT).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".button.is-rounded.is-secondary")));
        return driver.findElement(By.cssSelector(".button.is-rounded.is-secondary")).isDisplayed();
    }

    public ProductsPage allItems(){
        driver.findElement(ITEM_MENU).click();
        return this;
    }

    public LoginPage logout(){
        driver.findElement(LOGOUT).click();
        return new LoginPage(driver);
    }

    public CartPage goToCart(){
        driver.findElement(SHOPPING_CART_ICON).click();
        return new CartPage(driver);
    }
}
