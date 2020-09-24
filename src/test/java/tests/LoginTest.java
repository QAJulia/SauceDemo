package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    public void correctLogin(){
        loginPage
                .openPage()
                .login(System.getProperty(USERNAME), System.getProperty(PASSWORD))
                .isPageOpened();
    }

    @Test
    public void emptyLogin(){
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("",PASSWORD)
                .getErrorMessage();
        assertEquals(actualMessage,"Epic sadface: Username is required");
    }

    @Test
    public void emptyPassword(){
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME,"")
                .getErrorMessage();
        assertEquals(actualMessage,"Epic sadface: Password is required");
    }

    @Test
    public void incorrectLogin(){
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("name","password")
                .getErrorMessage();
        assertEquals(actualMessage,"Epic sadface: Username and password do not match " +
                "any user in this service");
    }
}