package project2;
/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Test {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static String browser = "Chrome";
    static WebDriver driver;
    public static void main(String[] args) {

        // Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefix")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else{
            System.out.println("Wrong Browser Name");
        }

        //Open the URL into Browser
        driver.get(baseUrl);

        //Maximise the browser
        driver.manage().window().maximize();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the title of the page.
        String title = driver.getTitle();
        System.out.println(title);

        //Get Current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());

        //Get Page Source
        System.out.println(driver.getPageSource());

        //Click on Forgot your password
        driver.findElement(By.cssSelector("p[class^='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        //current url
        System.out.println("Current URL : " + driver.getCurrentUrl());

        //navigate back
        driver.navigate().back();
        System.out.println(" Get Current Url " + driver.getCurrentUrl());

       //Refresh the page
        driver.navigate().refresh();

        //Find Email field Element ant Type the Email
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("Admin");

        //Find Password field Element ant Type the Email
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("admin123");

        // Click on login button
        driver.findElement(By.cssSelector("button[type^='submit']")).click();

        //Closing browser
        driver.quit();

    }
}
