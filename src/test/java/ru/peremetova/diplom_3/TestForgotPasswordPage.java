package ru.peremetova.diplom_3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.prermetova.diplom_3.ForgotPasswordPage;
import ru.prermetova.diplom_3.LoginPage;
import ru.prermetova.diplom_3.MainPage;

public class TestForgotPasswordPage {
    private WebDriver driver;

    @Before
    public void connectToServer() {
        driver = Config.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName(value = "Вход через кнопку в форме восстановления пароля")
    @Description(value = "Вход через кнопку в форме восстановления пароля")
    public void testRegister() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForStart();
        loginPage.fillRegisterDataAndLogin(Config.LOGIN_EMAIL, Config.PASSWORD);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForCanMakeOrder();
    }

}
