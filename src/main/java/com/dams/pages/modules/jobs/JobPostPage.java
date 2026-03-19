package com.dams.pages.modules.jobs;

import com.dams.report.CustomHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobPostPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for Sidebar and Cards
    private By jobsSidebarMenu = By.xpath("//a[@href='/jobs']");
    private By jobPostCard = By.xpath("//div[contains(text(), 'Job Post')]");
    
    // Locators for Verification on the Job Post page
    private By postAJobButton = By.xpath("//span[contains(text(), 'Post A Job')]/parent::button");

    public JobPostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToJobPost() {
        // Step 1: Click the 'Jobs' module in the sidebar (or navigate back to /jobs card overview)
        wait.until(ExpectedConditions.elementToBeClickable(jobsSidebarMenu)).click();
        CustomHtmlReporter.logStep("POST_1", "Job Post", "STEP 1 - Navigate Back to 'Jobs' Module View", "PASS", "-");
        
        // Step 2: Click the 'Job Post' card
        wait.until(ExpectedConditions.elementToBeClickable(jobPostCard)).click();
        CustomHtmlReporter.logStep("POST_2", "Job Post", "STEP 2 - Click 'Job Post' Card", "PASS", "-");
    }

    public boolean verifyJobPostPageLoaded() {
        try {
            // Step 3: Verify the 'Post A Job' action button is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(postAJobButton));
            CustomHtmlReporter.logStep("POST_3", "Job Post", "STEP 3 - Verify 'Post A Job' Button Loads", "PASS", "-");
            return true;
        } catch (Exception e) {
            CustomHtmlReporter.logStep("POST_3", "Job Post", "STEP 3 - Verify 'Post A Job' Button Loads", "FAIL", "-");
            return false;
        }
    }
}
