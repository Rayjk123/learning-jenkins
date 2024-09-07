package com.panda.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void test1() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver();
        // Wait up to 5 seconds for finding stuff
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println("Heading to nike.com");
        driver.get("https://www.nike.com/");

        System.out.println("Looking for sign in button");
        final WebElement signInButton = driver.findElement(By.xpath("//button/p[text()='Sign In']"));
        System.out.println("Sign in button found");

//        TimeUnit.SECONDS.sleep(3);
        signInButton.click();
        System.out.println("Sign in button clicked");
//        TimeUnit.SECONDS.sleep(5);

        final WebElement emailInput = driver.findElement(By.id("username"));

//        TimeUnit.SECONDS.sleep(3);
        emailInput.sendKeys("asodfjwoqiefjl");
//        TimeUnit.SECONDS.sleep(3);

        final WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continue']"));
        continueButton.click();

        final WebElement emailErrorMessage = driver.findElement(By.xpath("//span[@data-testid='support-text']"));

        assertEquals(emailErrorMessage.getText(), "Invalid email address");
//        TimeUnit.SECONDS.sleep(5);

//        textBox.sendKeys("Selenium");
//
//        final WebElement message = driver.findElement(By.id("message"));
//        // EXPECT THIS TO BE TRUE
//        assertEquals(message.getText(), "Received!");
////        assertEquals(message.getText(), "!");
//
//        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }
}
