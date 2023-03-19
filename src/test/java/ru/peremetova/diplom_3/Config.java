package ru.peremetova.diplom_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Config {
    public static final String REGISTER_NAME = "Test" + System.nanoTime();
    public static final String REGISTER_EMAIL = "test" + System.nanoTime() + "@test.ru";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_SHORT = "pass";
    public static final String LOGIN_EMAIL = "test1000@test.ru";
    public static final DriverType DRIVER_TYPE = DriverType.CHROME;

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver;
        switch (DRIVER_TYPE) {
            case CHROME:
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Неизвестный тип драйвера " + DRIVER_TYPE);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    enum DriverType {
        CHROME,
        FIREFOX
    }
}
