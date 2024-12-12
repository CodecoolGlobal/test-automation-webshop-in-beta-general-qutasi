package com.codecool.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPageTest extends BaseTest {
    
    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user");
    }
    
    @Test
    @DisplayName("After adding the product to the cart, the button text changes to Remove")
    public void testAddingProductToCart(){
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        assertTrue(inventoryPage.isProductInCart("Sauce Labs Backpack"));
    }
    @Test
    public void testRemoveProductFromCart(){
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.removeProductFromCart("Sauce Labs Backpack");
        assertFalse(inventoryPage.isProductInCart("Sauce Labs Backpack"));
    }
    
    @Test
    public void testLogoutFromPage(){
        inventoryPage.logout();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

}
