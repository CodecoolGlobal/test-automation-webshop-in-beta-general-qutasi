package com.codecool.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends BasePage{
    @FindBy(id ="back-to-products")
    private WebElement backHomeButton;
    @FindBy(xpath = "//*[@data-test='complete-header']")
    private WebElement completeText;

    public CheckoutCompletePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void clickOnBackHomeButton() {
        backHomeButton.click();
    }

    public boolean completeTextEquals(String text) {
        return completeText.getText().equals(text);
    }
}
