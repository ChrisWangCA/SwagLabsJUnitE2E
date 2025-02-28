package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author Chris Wang
 * @date 2025-02-27
 * This class represents the cart page
 */
public class CartPage {

    private WebDriver driver;

    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }

}
