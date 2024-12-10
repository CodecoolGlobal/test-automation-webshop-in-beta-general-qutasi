package com.codecool.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement errorMessage;

    private static final String PASSWORD = "secret_sauce";
    private static final String STANDARD_USERNAME = "standard_user";

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void standardLogin() {
        username.sendKeys(STANDARD_USERNAME);
        password.sendKeys(PASSWORD);
        loginButton.click();
    }

    public void login(String username) {
        this.username.sendKeys(username);
        this.password.sendKeys(PASSWORD);
        this.loginButton.click();
    }

    public void loginWithPassword(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
