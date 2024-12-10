package com.codecool.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;

    public BasePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    public void goToShoppingCartPage(){
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']"));
        shoppingCart.click();
    }
}
