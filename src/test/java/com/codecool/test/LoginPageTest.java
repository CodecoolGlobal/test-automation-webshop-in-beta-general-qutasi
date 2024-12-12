package com.codecool.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertEquals;

public class LoginPageTest extends BaseTest{
    @BeforeEach
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/usernames.csv", numLinesToSkip = 1)
    public void testLogin(String username, String expectedUrl) {
        loginPage.login(username);
        String url = driver.getCurrentUrl();
        assertEquals(expectedUrl, url);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalidPasswords.csv", numLinesToSkip = 1)
    public void testInvalidPasswords(String username, String password, String expectedUrl, String errorMessage) {
        loginPage.loginWithPassword(username, password);
        assertEquals(expectedUrl, driver.getCurrentUrl());
        assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalidUsernames.csv", numLinesToSkip = 1)
    public void testInvalidUsernames(String username, String expectedUrl, String errorMessage){
        loginPage.login(username);
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Test
    public void testErrorMessage(){
        loginPage.login("");
        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertEquals("Epic sadface: Username is required", errorMessage);
    }
}
