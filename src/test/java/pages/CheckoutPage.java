package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author Chris Wang
 * @date 2025-02-27
 * This class represents the checkout process page
 * It handles entering customer information during the checkout process and completing the order.
 */
public class CheckoutPage {

    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterFirstName(String firstname){
        driver.findElement(firstNameField).sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        driver.findElement(lastNameField).sendKeys(lastname);
    }

    public void enterZipCode(String zip){
        driver.findElement(zipCodeField).sendKeys(zip);
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public void clickFinish(){
        driver.findElement(finishButton).click();
    }
}
