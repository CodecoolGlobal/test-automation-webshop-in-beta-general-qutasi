package com.codecool.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class InventoryPage extends BasePage {
    @FindBy(xpath = "//div[@data-test='inventory-item']")
    private List<WebElement> inventoryItems;
    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement productSort;
    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement shoppingCartLink;
    @FindBy(id ="react-burger-menu-btn")
    private WebElement burgerMenuBtn;
    @FindBy(id ="logout_sidebar_link")
    private WebElement logoutButton;

    public InventoryPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public boolean isProductInCart(String productName) {
        WebElement productElement = getProduct(productName);
        try {
            productElement.findElement(By.xpath(".//button[text()='Remove']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addProductToCart(String productName) {
        WebElement productElement = getProduct(productName);
        if (productElement != null) {
            clickOnAddToCartButton(productElement);
        }
    }

    public void removeProductFromCart(String productName) {
        WebElement productElement = getProduct(productName);
        if (productElement != null) {
            clickOnRemoveFromCartButton(productElement);
        }
    }

    private void clickOnRemoveFromCartButton(WebElement productElement) {
        WebElement removeButton = productElement.findElement(By.xpath(".//button[text()='Remove']"));
        removeButton.click();
    }

    private void clickOnAddToCartButton(WebElement productElement) {
        WebElement addToCartButton = productElement.findElement(By.xpath(".//button[text()='Add to cart']"));
        addToCartButton.click();
    }

    private WebElement getProduct(String productName) {

        return inventoryItems.stream()
                .filter(e -> hasName(e, productName))
                .findAny()
                .orElse(null);
    }

    private boolean hasName(WebElement element, String productName) {
        try {
            WebElement title = element.findElement(By.xpath(".//div[@data-test='inventory-item-name']"));
            return title.getText().equals(productName);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void showProductDetails(String productName) {
        WebElement productElement = getProduct(productName);
        if (productElement != null) {
            WebElement title = productElement.findElement(By.xpath(".//div[@data-test='inventory-item-name']"));
            title.click();
        } else {
            System.out.println("No product found with name " + productName);
        }
    }

    public void logout(){
        burgerMenuBtn.click();
        logoutButton.click();
    }
}
