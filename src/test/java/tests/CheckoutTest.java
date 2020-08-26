package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void correctData(){
        loginPage.openPage();
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        cartPage.checkOut();
        checkoutPage.informationCheckout(FIRST_NAME, LAST_NAME, ZIP);
        assertEquals(checkoutPage.checkoutPageUniqueLocator(), "div");
    }

    @Test
    public void emptyFields(){
        loginPage.openPage();
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        cartPage.checkOut();
        checkoutPage.informationCheckout("", "", "");
        assertEquals(checkoutPage.getErrorMessage(),"Error: First Name is required");
    }

    @Test
    public void incorrectData(){
        loginPage.openPage();
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        cartPage.checkOut();
        checkoutPage.informationCheckout("1", "2", "qwerty");
        assertEquals(checkoutPage.getErrorMessage(),"Error: Incorrect Information");
    }

    @Test
    public void finishOrder(){
        loginPage.openPage();
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        cartPage.checkOut();
        checkoutPage.informationCheckout(FIRST_NAME, LAST_NAME, ZIP);
        checkoutPage.finishOrder();
        assertEquals(checkoutPage.finishPageUniqueLocator(), "div");
    }
}
