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
import ru.prermetova.diplom_3.ProfilePage;

public class TestProfilePage {
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
    @DisplayName(value = "Переход по клику на «Личный кабинет»")
    @Description(value = "Авторизация и вход в личный кабинет")
    public void testLoginAndEnterProfilePage() {
        loginAndEnterProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForCanExit();
    }

    @Test
    @DisplayName(value = "Переход из личного кабинета в конструктор")
    @Description(value = "При клике на логотип Stellar Burgers")
    public void testReturnToMainPageOnLogoClick() {
        loginAndEnterProfile();
        MainHeader mainHeader = new MainHeader(driver);
        mainHeader.clickOnMainLogo();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMain();
    }

    @Test
    @DisplayName(value = "Переход из личного кабинета в конструктор")
    @Description(value = "При клике на логотип кнопку - Конструктор")
    public void testReturnToMainPageOnConstructorClick() {
        loginAndEnterProfile();
        MainHeader mainHeader = new MainHeader(driver);
        mainHeader.clickOnConstructorButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMain();
    }

    @Test
    @DisplayName(value = "Выход из аккаунта")
    @Description(value = "Выход по кнопке «Выйти» в личном кабинете")
    public void testLogOutFromProfilePage() {
        loginAndEnterProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForCanExit();
        profilePage.clickExitButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForStart();
    }

    private void loginAndEnterProfile() {
        MainHeader mainHeader = new MainHeader(driver);
        mainHeader.clickOnCabinetButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForStart();
        loginPage.fillRegisterDataAndLogin(Config.LOGIN_EMAIL, Config.PASSWORD);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForCanMakeOrder();
        mainHeader.clickOnCabinetButton();
    }
}
