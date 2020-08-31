package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest{

    @Test
    public void sortProductsByNameAZ() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        assertEquals(productsPage.sortProducts("az"),"Sauce Labs Backpack");
    }

    @Test
    public void sortProductsByNameZA() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        assertEquals(productsPage.sortProducts("za"),"Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void sortProductsByPriceLowToHigh() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        assertEquals(productsPage.sortProducts("lohi"),"Sauce Labs Onesie");
    }

    @Test
    public void sortProductsByPriceHighToLow() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        assertEquals(productsPage.sortProducts("hilo"),"Sauce Labs Fleece Jacket");
    }

    @Test
    public void displayInventoryDetailsAndGoBack() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.displayInformationAboutProduct("Sauce Labs Backpack");
        assertTrue(productsPage.isPageOpened());
    }

    @Test
    public void aboutPageShouldBeOpened(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openMenu();
        assertTrue(productsPage.isAboutPageOpened());
    }

    @Test
    public void logout(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openMenu();
        productsPage.logout();
        assertTrue(loginPage.isPageOpened());
    }
}
