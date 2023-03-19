package ru.prermetova.diplom_3;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MainPage {
    private final WebDriver driver;

    private final By loginButton = By.xpath("//*[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath("//*[text()='Оформить заказ']");
    private final By mainTitle = By.xpath("//*[text()='Соберите бургер']");
    private final By ingredientListTitleBuns = By.xpath("//h2[text()='Булки']");
    private final By ingredientListTitleSouses = By.xpath("//h2[text()='Соусы']");
    private final By ingredientListTitleFilings = By.xpath("//h2[text()='Начинки']");
    private final By tabBuns = By.xpath("//*[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[1]/span");
    private final By tabSouses = By.xpath("//*[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[2]/span");
    private final By tabFillings = By.xpath("//*[@class='BurgerIngredients_ingredients__1N8v2']/div[1]/div[3]/span");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ждем появления кнопки - Войти в аккаунт")
    public void waitForCanLogin() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    @Step("Ждем появления кнопки - Оформить заказ")
    public void waitForCanMakeOrder() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    @Step("Ждем возможности кликнуть на - Войти в аккаунт")
    public void waitForCanCanClickProfileButton() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
    }

    @Step("Кликаем на кнопку - Войти в аккаунт")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    @Step("Ждем загрузки главной страницы")
    public void waitForLoadMain() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(mainTitle));
    }

    @Step("Кликаем на таб - Булки")
    public void clickTabBuns() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tabBuns))
                .click()
                .perform();
    }

    @Step("Кликаем на таб - Соусы")
    public void clickTabSouses() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tabSouses))
                .click()
                .perform();
    }

    @Step("Кликаем на таб - Начинки")
    public void clickTabFillings() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tabSouses))
                .click()
                .perform();
    }

    @Step("Ждем прокрутки до раздела - Булки")
    public void waitForScrollToBuns() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(ingredientListTitleBuns));
    }

    @Step("Ждем прокрутки до раздела - Соусы")
    public void waitForScrollToSouses() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(ingredientListTitleSouses));
    }

    @Step("Ждем прокрутки до раздела - Начинки")
    public void waitForScrollToFillings() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(ingredientListTitleFilings));
    }
}
