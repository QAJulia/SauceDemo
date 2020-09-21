package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest{

    @Test
    public void productShouldBeAddedIntoCart(){
        String cartList = loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Backpack")
                .goToCart()
                .isPageOpened()
                .productInTheList();
        assertEquals(cartList, "Sauce Labs Backpack");
    }

    @Test
    public void threeProductShouldBeAddedIntoCart(){
        int cartListSize = loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Backpack")
                .addProduct("Sauce Labs Bike Light")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .goToCart()
                .isPageOpened()
                .sizeOfCartList();
        assertEquals(cartListSize, 3);
    }

    @Test
    public void removeProductFromCart(){
        int cartListSize = loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Backpack")
                .addProduct("Sauce Labs Bike Light")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .goToCart()
                .isPageOpened()
                .removeProduct("Sauce Labs Backpack")
                .sizeOfCartList();
        assertEquals(cartListSize, 2);
    }

    @Test
    public void clearCart(){
        int cartListSize = loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Backpack")
                .addProduct("Sauce Labs Bike Light")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .goToCart()
                .isPageOpened()
                .openMenu()
                .resetAppState()
                .closeMenu()
                .refreshPage()
                .sizeOfCartList();
        assertEquals(cartListSize,0);
    }

    @Test
    public void goToAllItemsPageThroughTheMenu(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Backpack")
                .addProduct("Sauce Labs Bike Light")
                .addProduct("Sauce Labs Bolt T-Shirt")
                .goToCart()
                .isPageOpened()
                .openMenu()
                .allItems()
                .isPageOpened();
    }

    @Test
    public void continueShopping(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .addProduct("Sauce Labs Backpack")
                .goToCart()
                .continueShopping()
                .isPageOpened();
    }
}