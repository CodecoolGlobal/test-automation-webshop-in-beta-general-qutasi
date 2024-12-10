package com.codecool.models;

import com.codecool.data.Item;
import com.codecool.util.MoneyConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(xpath="//div[@data-test='inventory-item']")
    private List<WebElement> inventoryItems;
    @FindBy(xpath = "//button[@data-test='checkout']")
    private WebElement checkoutButton;


    public CartPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public boolean isItemInCart(String itemName) {
        for (WebElement item : inventoryItems) {
            WebElement title = item.findElement(By.xpath(".//div[@data-test='inventory-item-name']"));
            if(title.getText().equals(itemName)){
                return true;
            }
        }
        return false;
    }
    public boolean isItemInCart(List<String> itemNames) {
        for (String itemName : itemNames) {
            if(!isItemInCart(itemName)) {
                return false;
            }
        }
        return true;
    }

    public void checkout() {
        checkoutButton.click();
    }

    private Item buildItem(WebElement item) {
        return new Item(
                getProperty(item, "inventory-item-name"),
                getProperty(item, "inventory-item-desc"),
                MoneyConverter.asCents(getProperty(item, "inventory-item-price")),
                getProperty(item, "item-quantity")
        );
    }

    private String getProperty(WebElement item, String property) {
        String xpath = "//div[@data-test='%s']".formatted(property);
        return item.findElement(By.xpath(xpath)).getText();
    }
    public void deleteItem(String name) {
        String xpath = ".//button[contains(@id, 'remove-')]";
        inventoryItems.stream()
                .filter(item -> item.getText().contains(name))
                .findAny().orElseThrow(() -> new RuntimeException("item name not found"))
                .findElement(By.xpath(xpath))
                .click();
    }
}
