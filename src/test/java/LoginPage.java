import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;

    @Test
    public void loginPageTest() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        driver = new OperaDriver();
        driver.get("https://www.saucedemo.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.quit();
    }
}
