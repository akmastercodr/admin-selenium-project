package com.dams.pages.modules.jobs;

import com.dams.report.CustomHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppliedJobsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for Sidebar and Cards
    private By jobsSidebarMenu = By.xpath("//a[@href='/jobs']");
    private By appliedJobCard = By.xpath("//div[contains(text(), 'Applied Job')]");
    
    // Locators for Verification on the Applied Jobs page
    private By userNameColumn = By.xpath("//th[contains(., 'User Name')]");

    public AppliedJobsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToAppliedJobs() {
        // Step 1: Click the 'Jobs' module in the sidebar
        wait.until(ExpectedConditions.elementToBeClickable(jobsSidebarMenu)).click();
        CustomHtmlReporter.logStep("Applied Jobs Module", "JOBS_1", "Applied Jobs", "STEP 1 - Click 'Jobs' Sidebar Menu", "PASS", "-");
        
        // Step 2: Click the 'Applied Job' card
        wait.until(ExpectedConditions.elementToBeClickable(appliedJobCard)).click();
        CustomHtmlReporter.logStep("Applied Jobs Module", "JOBS_2", "Applied Jobs", "STEP 2 - Click 'Applied Job' Card", "PASS", "-");
    }

    public boolean verifyAppliedJobsPageLoaded() {
        try {
            // Step 3: Verify the data table column 'User Name' is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(userNameColumn));
            CustomHtmlReporter.logStep("Applied Jobs Module", "JOBS_3", "Applied Jobs", "STEP 3 - Verify 'Applied Jobs' Data Table Loads", "PASS", "-");
            return true;
        } catch (Exception e) {
            CustomHtmlReporter.logStep("Applied Jobs Module", "JOBS_3", "Applied Jobs", "STEP 3 - Verify 'Applied Jobs' Data Table Loads", "FAIL", "-");
            return false;
        }
    }
}
