package ru.prermetova.diplom_3;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MainHeader {
    private final WebDriver driver;

    private final By cabinetButton = By.xpath("//*[@href='/account']");
    private final By logoImage = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']/a");
    private final By constructorButton = By.xpath("//*[text()='Конструктор']");

    public MainHeader(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Кликаем на кнопку - Личный кабинет")
    public void clickOnCabinetButton() {
        new Actions(driver)
                .moveToElement(driver.findElement(cabinetButton))
                .click()
                .perform();
    }

    @Step("Кликаем на главное лого")
    public void clickOnMainLogo() {
        driver.findElement(logoImage).click();
    }

    @Step("Кликаем на кнопку - Конструктор")
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }

}
