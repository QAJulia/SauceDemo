import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;
    /* locators
    driver.findElement(By.id("user-name"));
        driver.findElement(By.id("password"));
        driver.findElement(By.id("login-button"));
     */

    @BeforeMethod(alwaysRun = true)
    public void selAll(){
        System.setProperty("webdriver.opera.driver", "src/test/resources/operadriver.exe");
        driver = new OperaDriver();
        driver.get("https://www.saucedemo.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void validData() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String addButton = driver.findElement(By.cssSelector(".btn_primary.btn_inventory")).getTagName();
        Assert.assertEquals(addButton, "button");
    }
    @Test//нужно ли делать вообще этот тест, учитывая что ниже есть похожие с пустыми полями?
    public void emptyFields() {
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String addButton = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(addButton, "Epic sadface: Username is required");
    }

    @Test
    public void emptyUsernameField() {
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String addButton = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(addButton, "Epic sadface: Username is required");
    }

    @Test
    public void emptyPasswordField() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String addButton = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(addButton, "Epic sadface: Password is required");
    }

    @Test
    public void invalidData() {
        driver.findElement(By.id("user-name")).sendKeys("name");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        String addButton = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(addButton, "Epic sadface: Username and password do not match " +
                "any user in this service");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
