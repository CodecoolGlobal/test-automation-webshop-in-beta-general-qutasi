package com.codecool.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutStepOnePage extends BasePage{
    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;
    @FindBy(id = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void fillData(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
    }

    public boolean errorMessageEquals(String errorMessage) {
        return this.errorMessage.getText().equals(errorMessage);
    }

    public void cancel() {
        cancelButton.click();
    }
}
