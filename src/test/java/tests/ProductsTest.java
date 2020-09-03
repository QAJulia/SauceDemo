package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Test
    public void sortProductsByNameAZ() {
        String firstItem = loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .sortProducts("az");
        assertEquals(firstItem,"Sauce Labs Backpack");
    }

    @Test
    public void sortProductsByNameZA() {
        String firstItem = loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .sortProducts("za");
        assertEquals(firstItem,"Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void sortProductsByPriceLowToHigh() {
        String firstItem = loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .sortProducts("lohi");
        assertEquals(firstItem,"Sauce Labs Onesie");
    }

    @Test
    public void sortProductsByPriceHighToLow() {
        String firstItem = loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .sortProducts("hilo");
        assertEquals(firstItem,"Sauce Labs Fleece Jacket");
    }

    @Test
    public void displayInventoryDetailsAndGoBack() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .displayInformationAboutProduct("Sauce Labs Backpack")
                .isPageOpened();
    }

    @Test
    public void aboutPageShouldBeOpened(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .openMenu()
                .isAboutPageOpened();
    }

    @Test
    public void logout(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .openMenu()
                .logout()
                .isPageOpened();
    }
}