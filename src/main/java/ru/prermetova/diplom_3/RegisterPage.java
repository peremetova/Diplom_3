package ru.prermetova.diplom_3;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;
    // поле ввода "Имя"
    private final By nameField = By.xpath("//*[@class=\"Auth_form__3qKeq mb-20\"]/fieldset[1]/div/div/input");
    private final By emailField = By.xpath("//*[@class=\"Auth_form__3qKeq mb-20\"]/fieldset[2]/div/div/input");
    private final By passwordField = By.xpath("//*[@class=\"Auth_form__3qKeq mb-20\"]/fieldset[3]/div/div/input");
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//*[text()='Войти']");
    private final By wrongPasswordField = By.xpath("//*[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполняем поле - имя")
    public void fillName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполняем поле - email")
    public void fillEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполняем поле - пароль")
    public void fillPassword(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }

    @Step("Кликаем кнопку - Зарегистрироваться")
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    @Step("Кликаем кнопку - Войти")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    @Step("Проверяем видимость сообщения с ошибкой пароля")
    public boolean isPasswordErrorVisible(){
        return driver.findElement(wrongPasswordField).isDisplayed();
    }

    @Step("Заполняем поля формы регистрации")
    public void fillRegisterData(String name, String email, String password){
        fillName(name);
        fillEmail(email);
        fillPassword(password);
    }
}
