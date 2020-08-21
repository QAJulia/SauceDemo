import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsPage {

    WebDriver driver;
    /* locators
        driver.findElement(By.xpath("//*[@id = 'shopping_cart_container']/a"));
        driver.findElement(By.xpath("//button[text()='Open Menu']"));
        driver.findElement(By.xpath("//button[text()='Close Menu']"));
        driver.findElement(By.id("inventory_sidebar_link"));
        driver.findElement(By.id("about_sidebar_link"));
        driver.findElement(By.id("logout_sidebar_link"));
        driver.findElement(By.id("reset_sidebar_link"));
        driver.findElement(By.cssSelector(".product_sort_container"));
        driver.findElements(By.cssSelector(".inventory_item"));
        driver.findElement(By.cssSelector(".inventory_item_name"));
        driver.findElement(By.cssSelector(".inventory_item_price"));
        driver.findElement(By.cssSelector(".btn_primary.btn_inventory"));
        driver.findElements(By.cssSelector(".btn_secondary.btn_inventory"));
        driver.findElement(By.cssSelector(".inventory_details_back_button"));
        driver.findElement(By.cssSelector(".inventory_details_price"))
        driver.findElement(By.cssSelector(".inventory_details_name"))

     */

    @BeforeMethod(alwaysRun = true)
    public void selAll() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        driver = new OperaDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void displayItemsTest() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".inventory_item"));

        for (WebElement item : elements) {
            System.out.print("Item: " + item.findElement(By.cssSelector(".inventory_item_name")).getText() + "\t");
            System.out.println("Price: " + item.findElement(By.cssSelector(".inventory_item_price")).getText());
        }
        Assert.assertEquals(driver.findElements(By.cssSelector(".inventory_item")).size(), 6);

        /* print one element
        System.out.println(elements.get(0).findElement(By.cssSelector(".inventory_item_name")).getText() + ": " +
                elements.get(0).findElement(By.cssSelector(".inventory_item_price")).getText());
         */
    }

    @Test
    public void sortTest() {

        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        select.selectByValue("az");
        String text1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text1, "Name (A to Z)");
        select.selectByValue("za");
        String text2 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text2, "Name (Z to A)");
        select.selectByValue("lohi");
        String text3 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text3, "Price (low to high)");
        select.selectByValue("hilo");
        String text4 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text4, "Price (high to low)");
    }

    @Test
    public void inventoryDetailsTest() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".inventory_item"));
        elements.get(5).findElement(By.cssSelector(".inventory_item_name")).click();
        String backButton = driver.findElement(By.cssSelector(".inventory_details_back_button")).getTagName();
        Assert.assertEquals(backButton, "button");
        System.out.println(driver.findElement(By.cssSelector(".inventory_details_name")).getText() + ": " +
                driver.findElement(By.cssSelector(".inventory_details_price")).getText());
        driver.findElement(By.cssSelector(".btn_primary.btn_inventory")).click();
        driver.findElements(By.cssSelector(".btn_secondary.btn_inventory"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
