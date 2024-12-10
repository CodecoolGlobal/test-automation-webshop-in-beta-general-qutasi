package com.codecool.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasePage{
    @FindBy(xpath = "//button[@data-test='add-to-cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//button[@data-test='remove']")
    private WebElement removeButton;
    @FindBy(xpath = "//button[@data-test='back-to-products']")
    private WebElement backToProductsButton;
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private WebElement inventoryItemName;

    public ItemPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public boolean isProductInCart() {
        try {
            driver.findElement(By.xpath("//button[@data-test='remove']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isProductNameEqual(String productName) {
        return inventoryItemName.getText().equals(productName);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void removeFromCart() {
        removeButton.click();
    }

    public void backToProductsPage() {
        backToProductsButton.click();
    }
}
