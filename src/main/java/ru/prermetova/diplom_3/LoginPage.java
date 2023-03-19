package ru.prermetova.diplom_3;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginPage {
    private final WebDriver driver;
    private final By emailField = By.xpath("//*[@class=\"Auth_form__3qKeq mb-20\"]/fieldset[1]/div/div/input");
    private final By passwordField = By.xpath("//*[@class=\"Auth_form__3qKeq mb-20\"]/fieldset[2]/div/div/input");
    private final By loginButton = By.xpath("//*[text()='Войти']");
    private final By titleH2 = By.xpath("//*[text()='Вход']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ждем появления заголовка - Вход")
    public void waitForStart() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(titleH2));
    }

    @Step("Заполняем поле - email")
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполняем поле - пароль")
    public void fillPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    @Step("Кликаем на кнопку - Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Заполняем форму входа")
    public void fillRegisterData(String email, String password) {
        fillEmail(email);
        fillPassword(password);
    }

    @Step("Заполняем форму входа и кликаем на кнопку Войти")
    public void fillRegisterDataAndLogin(String email, String password) {
        fillRegisterData(email, password);
        clickLoginButton();
    }

}
