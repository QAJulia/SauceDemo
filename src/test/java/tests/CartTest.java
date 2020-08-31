package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest{

    @Test
    public void productShouldBeAddedIntoCart(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Backpack");
        cartPage.openPage();
        assertEquals(cartPage.productInTheList(), "Sauce Labs Backpack");
    }

    @Test
    public void threeProductShouldBeAddedIntoCart(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        assertEquals(cartPage.sizeOfCartList(), 3);
    }

    @Test
    public void removeProductFromCart(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        cartPage.removeProduct("Sauce Labs Backpack");
        assertEquals(cartPage.sizeOfCartList(), 2);
    }

    @Test
    public void clearCart(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        productsPage.openMenu();
        productsPage.resetAppState();
        productsPage.closeMenu();
        cartPage.refreshPage();
        assertEquals(cartPage.sizeOfCartList(),0);
    }

    @Test
    public void goToAllItemsPageThroughTheMenu(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        productsPage.openMenu();
        productsPage.allItems();
        assertTrue(productsPage.isPageOpened());
    }

    @Test
    public void continueShopping(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProduct("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.continueShopping();
        assertTrue(productsPage.isPageOpened());
    }
}
