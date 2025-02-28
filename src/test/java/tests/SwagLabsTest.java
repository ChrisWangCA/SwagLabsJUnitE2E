package tests;

import org.junit.jupiter.api.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

/**
 * @author Chris Wang
 * @date 2025-02-27
 * This is the main test class using JUnit 5
 */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SwagLabsTest extends BaseTest{


    private static LoginPage loginPage;
    private static ProductPage productPage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    @BeforeAll
    public static void setUp(){
        // Initialize our page objects
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        // Open the Swag Labs website
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    @Order(1)
    public void loginTest(){
        // Randomly pick one valid username
        String[] users = {
                "standard_user",
                "locked_out_user",
                "problem_user",
                "performance_glitch_user",
                "error_user",
                "visual_user"
        };

        int randomIndex = (int) (Math.random() * users.length);
        String randomUsers = users[randomIndex];

        // Fill in username, password and click login
        loginPage.enterUsername(randomUsers);
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Assert current page URL contains "inventory.html" to verify login success
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "login failed or not in the inventory page");
    };

    @Test
    @Order(2)
    public void addTwoRandomItemsToCartTest(){
        // Add two random products
        productPage.addRandomProducts(2);

        // Click the cart icon to go to the cart page
        productPage.goToCart();

        // Assert that the URL contains "cart.html"
        Assertions.assertTrue(driver.getCurrentUrl().contains("cart.html"),"" +
                "Not on the cart page");
    };

    @Test
    @Order(3)
    public void checkoutProcessTest(){
        // Click "Checkout"
        cartPage.clickCheckout();

        // Verify if it's in checkout-step-one
        Assertions.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"),
                "Not on checkout step one page");

        // Enter checkout information
        checkoutPage.enterFirstName("Chris");
        checkoutPage.enterLastName("Wang");
        checkoutPage.enterZipCode("123456");
        checkoutPage.clickContinue();

        // Verify if it's in checkout-step-two
        Assertions.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"),
                "Not on the checkout step two page");

        // Click "Finish" to complete the order
        checkoutPage.clickFinish();

        // Verify if it's on checkout-complete page
        Assertions.assertTrue(driver.getCurrentUrl().contains("checkout-complete.html"),
                "Not on the check complete page");
    }


}
