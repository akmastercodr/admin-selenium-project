package com.dams.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Robust XPaths that usually work for typical React/MUI forms
    private By emailInput = By.xpath("//input[@type='email' or contains(@name, 'email') or contains(@placeholder, 'Email')]");
    private By passwordInput = By.xpath("//input[@type='password' or contains(@name, 'password') or contains(@placeholder, 'Password')]");
    private By submitBtn = By.xpath("//button[@type='submit' or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'login')]");
    
    // Assuming OTP uses a standard input or placeholder
    private By otpInput = By.xpath("//input[contains(@name, 'otp') or contains(@placeholder, 'OTP') or @type='number']");
    private By verifyOtpBtn = By.xpath("//button[@type='submit' or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'verify') or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'submit')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void login(String email, String password, String otp) {
        // Enter Email
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        
        // Enter Password
        driver.findElement(passwordInput).sendKeys(password);
        
        // Click Login to trigger OTP
        driver.findElement(submitBtn).click();
        
        System.out.println("Login button clicked, waiting for OTP fields...");
        
        try {
            // Wait for OTP field and enter OTP
            wait.until(ExpectedConditions.visibilityOfElementLocated(otpInput)).sendKeys(otp);
            System.out.println("OTP entered successfully.");
            
            // Click Verify OTP if a distinct button appears
            try {
                driver.findElement(verifyOtpBtn).click();
            } catch(Exception e) {
                // Sometime the form just submits or the login button acts as verify
                driver.findElement(submitBtn).click();
            }
        } catch(Exception e) {
            System.out.println("WARNING: OTP locator strategy might need adjustment based on the actual DOM.");
            throw e;
        }
    }
}
