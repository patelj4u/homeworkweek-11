package utimateqa;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    String baseurl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //Click on 'Sign In' link
        WebElement SignInLink = driver.findElement(By.xpath("//li[@class='header_nav-item header_nav-sign-in']"));
        SignInLink.click();

        // Verify the text 'Welcome Back!'
        WebElement WelcomeBackText = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualText = WelcomeBackText.getText();
        String expectedText = "Welcome Back!";
        assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {

        // Click on the 'Sign In' link
        WebElement SignInLink = driver.findElement(By.cssSelector("a[href='/users/sign_in']"));
        SignInLink.click();

        // Enter invalid username
        WebElement username = driver.findElement(By.id("user[email]"));
        username.sendKeys("jiten@gmail.com");

        // Enter invalid password
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("123456");

        // Click on 'Sign In' button
        WebElement SignInButton = driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']"));
        SignInButton.click();

        // Verify the error message ‘Invalid email or password'
        WebElement invalidEmailorPassword = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualText = invalidEmailorPassword.getText();
        String expectedText = "Invalid email or password.";
        assertEquals(expectedText, actualText);
    }

    @After
    public void closeBrowser() {driver.quit();}
}

