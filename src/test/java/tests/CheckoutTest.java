package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void correctData(){
        loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .addProduct("Sauce Labs Bike Light")
                .goToCart()
                .isPageOpened()
                .checkOut()
                .isPageOpened()
                .informationOnCheckoutPage(FIRST_NAME, LAST_NAME, ZIP)
                .isSecondCheckoutPageOpened();
    }

    @Test
    public void emptyFirstNameField(){
        String errorMessage = loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .addProduct("Sauce Labs Bike Light")
                .goToCart()
                .isPageOpened()
                .checkOut()
                .isPageOpened()
                .wrongInformationOnCheckoutPage("", "qwerty", "12345")
                .getErrorMessage();
        assertEquals(errorMessage,"Error: First Name is required");
    }

    @Test
    public void emptyLastNameField(){
        String errorMessage = loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .addProduct("Sauce Labs Bike Light")
                .goToCart()
                .isPageOpened()
                .checkOut()
                .isPageOpened()
                .wrongInformationOnCheckoutPage("Qwerty", "", "12345")
                .getErrorMessage();
        assertEquals(errorMessage,"Error: Last Name is required");
    }

    @Test
    public void emptyZipField(){
        String errorMessage = loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .addProduct("Sauce Labs Bike Light")
                .goToCart()
                .isPageOpened()
                .checkOut()
                .isPageOpened()
                .wrongInformationOnCheckoutPage("Qwerty", "qwerty", "")
                .getErrorMessage();
        assertEquals(errorMessage,"Error: Postal Code is required");
    }

    @Test
    public void finishOrder(){
        loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .addProduct("Sauce Labs Bolt T-Shirt")
                .goToCart()
                .isPageOpened()
                .checkOut()
                .isPageOpened()
                .informationOnCheckoutPage(FIRST_NAME, LAST_NAME,ZIP)
                .isSecondCheckoutPageOpened()
                .completeCheckout()
                .isFinishPageOpened();
    }
}