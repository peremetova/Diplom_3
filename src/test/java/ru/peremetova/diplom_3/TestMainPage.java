package ru.peremetova.diplom_3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.prermetova.diplom_3.LoginPage;
import ru.prermetova.diplom_3.MainHeader;
import ru.prermetova.diplom_3.MainPage;

public class TestMainPage {
    private WebDriver driver;

    @Before
    public void connectToServer() {
        driver = Config.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName(value = "Вход по кнопке «Войти в аккаунт» на главной")
    @Description(value = "Вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginViaMainButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForStart();
        loginPage.fillRegisterDataAndLogin(Config.LOGIN_EMAIL, Config.PASSWORD);
        mainPage.waitForCanMakeOrder();
    }

    @Test
    @DisplayName(value = "Вход через кнопку «Личный кабинет»")
    @Description(value = "Вход через кнопку «Личный кабинет»")
    public void testLoginViaCabinetButton() {
        MainHeader mainHeader = new MainHeader(driver);
        mainHeader.clickOnCabinetButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForStart();
        loginPage.fillRegisterDataAndLogin(Config.LOGIN_EMAIL, Config.PASSWORD);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForCanMakeOrder();
    }

    @Test
    @DisplayName(value = "Раздел «Конструктор» - Булки")
    @Description(value = "Работает переход к разделу: «Булки»")
    public void testScrollToBuns() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTabBuns();
        mainPage.waitForScrollToBuns();
    }

    @Test
    @DisplayName(value = "Раздел «Конструктор» - Соусы")
    @Description(value = "Работает переход к разделу: «Соусы»")
    public void testScrollToSouses() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTabSouses();
        mainPage.waitForScrollToSouses();
    }

    @Test
    @DisplayName(value = "Раздел «Конструктор» - Начинки")
    @Description(value = "Работает переход к разделу: «Начинки»")
    public void testScrollToFillings() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTabFillings();
        mainPage.waitForScrollToFillings();
    }
}
