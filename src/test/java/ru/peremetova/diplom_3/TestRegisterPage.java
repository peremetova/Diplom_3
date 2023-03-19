package ru.peremetova.diplom_3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.prermetova.diplom_3.LoginPage;
import ru.prermetova.diplom_3.MainPage;
import ru.prermetova.diplom_3.RegisterPage;

public class TestRegisterPage {
    private WebDriver driver;

    @Before
    public void connectToServer() {
        driver = Config.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName(value = "Проверка регистрации")
    @Description(value = "Открываем страницу регистрации, заполняем поля и жмем кнопку Зарегистрироваться")
    public void testRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillRegisterData(Config.REGISTER_NAME, Config.REGISTER_EMAIL, Config.PASSWORD);
        registerPage.clickRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForStart();
    }

    @Test
    @DisplayName(value = "Проверка регистрации с коротким паролем")
    @Description(value = "Ожидается появление сообщения об ошибке")
    public void testRegisterShortPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillRegisterData(Config.REGISTER_NAME, Config.REGISTER_EMAIL, Config.PASSWORD_SHORT);
        registerPage.clickRegisterButton();
        boolean hasError = registerPage.isPasswordErrorVisible();
        Assert.assertTrue("Не показана ошибка - Некорректный пароль", hasError);
    }

    @Test
    @DisplayName(value = "Вход через кнопку в форме регистрации")
    @Description(value = "Вход через кнопку в форме регистрации")
    public void testLoginViaRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForStart();
        loginPage.fillRegisterDataAndLogin(Config.LOGIN_EMAIL, Config.PASSWORD);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForCanMakeOrder();
    }
}
