import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsPage {

    WebDriver driver;

    @Test
    public void productsPageTest() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        driver = new OperaDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id = 'shopping_cart_container']/a"));

        driver.findElement(By.xpath("//button[text()='Open Menu']"));
        driver.findElement(By.xpath("//button[text()='Close Menu']"));
        driver.findElement(By.id("inventory_sidebar_link"));
        driver.findElement(By.id("about_sidebar_link"));
        driver.findElement(By.id("logout_sidebar_link"));
        driver.findElement(By.id("reset_sidebar_link"));


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

        List<WebElement> elements = driver.findElements(By.cssSelector(".inventory_item"));
        /* print all elements
        for (WebElement item : elements) {
            System.out.print("Item: " + item.findElement(By.cssSelector(".inventory_item_name")).getText() + "\t");
            System.out.println("Price: " + item.findElement(By.cssSelector(".inventory_item_price")).getText());
        }
         */
        /* print one element
        System.out.println(elements.get(0).findElement(By.cssSelector(".inventory_item_name")).getText() + ": " +
                elements.get(0).findElement(By.cssSelector(".inventory_item_price")).getText());
         */

        elements.get(5).findElement(By.cssSelector(".inventory_item_name")).click();
        driver.findElement(By.cssSelector(".btn_primary.btn_inventory")).click();
        driver.findElements(By.cssSelector(".btn_secondary.btn_inventory"));
        driver.findElement(By.cssSelector(".inventory_details_back_button")).click();

        driver.findElements(By.cssSelector(".btn_primary.btn_inventory")).get(0).click();
        driver.findElements(By.cssSelector(".btn_secondary.btn_inventory"));

        driver.quit();
    }
}
