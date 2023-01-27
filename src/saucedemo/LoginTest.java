package saucedemo;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Enter 'standard_user' username
        WebElement Username = driver.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");

        // Enter 'admin123' as password
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");

        // Click on 'Login' button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify the text 'PRODUCTS'
        WebElement productsText = driver.findElement(By.xpath("//span[text()='Products']"));
        String actualText = productsText.getText();
        String expectedText = "PRODUCTS";
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        // Enter 'standard_user' username
        WebElement Username = driver.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");

        // Enter 'admin123' as password
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");

        // Click on 'Login' button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify that six products are displayed on page
        int expectedCount = 6;
        int actualCount = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        Assert.assertEquals(expectedCount,actualCount);

    }

    @After
    public void closeBrowser() {driver.quit();}
}


