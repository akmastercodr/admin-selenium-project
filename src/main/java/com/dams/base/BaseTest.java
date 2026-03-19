package com.dams.base;

import com.dams.driver.DriverFactory;
import com.dams.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // Initialize the browser
        driver = DriverFactory.initDriver();
        System.out.println("Navigating to https://devadmin.damsdelhi.com/");
        driver.get("https://devadmin.damsdelhi.com/");
        
        // Initialize the Page Objects
        loginPage = new LoginPage(driver);
        
        // Execute the login flow (happens before every test inheriting BaseTest)
        loginPage.login("07siddwivedi@gmail.com", "Siddarth@123", "1980");
        
        // Pause to allow dashboard routing and rendering to complete
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
