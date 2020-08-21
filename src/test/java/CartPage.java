import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartPage {

    WebDriver driver;

    @Test
    public void cartPageTest(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        driver = new OperaDriver();
        driver.get("https://www.saucedemo.com/cart.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[text()='Continue Shopping']")).click();
        driver.findElement(By.cssSelector(".btn_primary.btn_inventory")).click();
        driver.findElement(By.xpath("//*[@id = 'shopping_cart_container']/a")).click();
        driver.findElements(By.cssSelector(".inventory_item_name"));
        driver.findElements(By.cssSelector(".btn_secondary.cart_button"));
        driver.findElement(By.cssSelector(".checkout_button"));

        driver.quit();

        //*[@id="shopping_cart_container"]/a/svg/path
    }
}
