package com.codecool.test;

import com.codecool.models.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    private static final Duration TIMEOUT = Duration.ofSeconds(3);

    protected RemoteWebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected ItemPage itemPage;
    protected CartPage cartPage;
    protected CheckoutStepOnePage checkoutStepOnePage;
    protected CheckoutStepTwoPage checkoutStepTwoPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeAll
    public void beforeAll() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"),
                new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        wait = new WebDriverWait(driver, TIMEOUT);
        actions = new Actions(driver);

        loginPage = new LoginPage(driver, wait, actions);
        inventoryPage = new InventoryPage(driver, wait, actions);
        itemPage = new ItemPage(driver, wait, actions);
        cartPage = new CartPage(driver, wait, actions);
        checkoutStepOnePage = new CheckoutStepOnePage(driver, wait, actions);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver, wait, actions);
        checkoutCompletePage = new CheckoutCompletePage(driver, wait, actions);
    }

    @AfterAll
    public void afterAll() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
