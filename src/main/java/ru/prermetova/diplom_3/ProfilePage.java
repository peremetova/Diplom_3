package ru.prermetova.diplom_3;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ProfilePage {
    private final WebDriver driver;

    private final By logoImage = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    private final By exitButton = By.xpath("//*[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ждем появления кнопки - Выход")
    public void waitForCanExit() {
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }

    @Step("Кликаем на кнопку - Выход")
    public void clickExitButton() {
        new Actions(driver)
                .moveToElement(driver.findElement(exitButton))
                .click()
                .perform();
    }
}
