package com.codecool.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends BaseTest{
    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
    }

    @ParameterizedTest
    @DisplayName("Test buying a product")
    @CsvFileSource(resources = "/validBuyerCredentials.csv", numLinesToSkip = 1)
    public void testCheckoutWithValidCredentials(String username, String firstName, String lastName, String zipCode, String checkoutText) {
        loginPage.login(username);
        inventoryPage.goToShoppingCartPage();
        cartPage.checkout();
        checkoutStepOnePage.fillData(firstName, lastName, zipCode);
        checkoutStepTwoPage.finish();
        assertTrue(checkoutCompletePage.completeTextEquals(checkoutText));
    }
    @ParameterizedTest
    @DisplayName("Test trying to buy a product with invalid credentials")
    @CsvFileSource(resources = "/invalidBuyerCredentials.csv", numLinesToSkip = 1)
    public void testCheckoutWithInvalidCredentials(String username, String firstName, String lastName, String zipCode, String expectedMessage) {
        loginPage.login(username);
        inventoryPage.goToShoppingCartPage();
        cartPage.checkout();
        checkoutStepOnePage.fillData(firstName, lastName, zipCode);
        assertTrue(checkoutStepOnePage.errorMessageEquals(expectedMessage));
    }
}
