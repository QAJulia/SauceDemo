package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    @Description("Логин, используя корректные данные")
    public void correctLogin(){
        loginPage
                .openPage()
                .login(USERNAME,PASSWORD)
                .isPageOpened();
    }

    @Test
    @Description("Ошибка при использовании пустого поля имени")
    public void emptyLogin(){
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("",PASSWORD)
                .getErrorMessage();
        assertEquals(actualMessage,"Epic sadface: Username is required");
    }

    @Test
    @Description("Ошибка при использовании пустого поля пароля")
    public void emptyPassword(){
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME,"")
                .getErrorMessage();
        assertEquals(actualMessage,"Epic sadface: Password is required");
    }

    @Test
    @Description("Ошибка при использовании несуществующих данных")
    public void incorrectLogin(){
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("name","password")
                .getErrorMessage();
        assertEquals(actualMessage,"Epic sadface: Username and password do not match " +
                "any user in this service");
    }
}