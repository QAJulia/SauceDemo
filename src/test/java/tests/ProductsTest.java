package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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
        assertEquals(productsPage.secondPageUniqueLocator(), "div");
    }

    @Test
    public void aboutPageShouldBeOpened(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openMenu();
        assertEquals(productsPage.goToAboutPage(), "a");
    }

    @Test
    public void logout(){
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openMenu();
        assertEquals(productsPage.logout(), "input");
    }
}
