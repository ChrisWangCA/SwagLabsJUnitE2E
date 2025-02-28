package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Chris Wang
 * @date 2025-02-27
 * This class represents the Login Page of Swag Labs.
 * It contains methods to interact with login page elements, including entering username, entering password, and clicking the login button.
 */
public class LoginPage {

    private WebDriver driver;

    // Locator: username field
    private By usernameField = By.id("user-name");

    // Locator: password field
    private By passwordField = By.name("password");

    // Locator: login button
    private By loginButton = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
}
