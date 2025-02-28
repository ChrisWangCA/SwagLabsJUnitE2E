package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

/**
 * @author Chris Wang
 * @date 2025-02-27
 * This class represents the products inventory page
 */
public class ProductPage {

    private WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(ProductPage.class);

    // Locator: All product items on the page
    private By inventoryItems = By.className("inventory_item");

    // Locator: Product name within each product item
    private By itemName = By.className("inventory_item_name");

    // Locator: Add to Cart button within each product item
    private By addToCartButton = By.cssSelector(".inventory_item button");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Adds a specified number of random products to the cart
     * @param numberOfProducts Number of products to add
     */
    public void addRandomProducts(int numberOfProducts){
        List<WebElement> allItems = driver.findElements(inventoryItems);
        Random random = new Random();
        int totalItems = allItems.size();
        for(int i=0;i < numberOfProducts;i++){
            int randomIndex = random.nextInt(totalItems);
            WebElement randomItem = allItems.get(randomIndex);
            randomItem.findElement(addToCartButton).click();
            String productName = randomItem.findElement(itemName).getText();
            logger.info("Added to cart: " + productName);

            allItems.remove(randomIndex);
            totalItems--;
        }
    }

    /**
     * Navigates to the cart page
     */
    public void goToCart(){
        By cartLink = By.xpath("//a[@class='shopping_cart_link']");
        driver.findElement(cartLink).click();
    }
}
