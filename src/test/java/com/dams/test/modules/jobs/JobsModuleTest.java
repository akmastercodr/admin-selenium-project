package com.dams.test.modules.jobs;

import com.dams.base.BaseTest;
import com.dams.pages.modules.jobs.AppliedJobsPage;
import com.dams.pages.modules.jobs.JobPostPage;
import com.dams.report.CustomHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsModuleTest extends BaseTest {

    @Test(priority = 1)
    public void executeAppliedJobsVerification() {
        // BaseTest automatically handles spinning up Chrome and completing the DAMS Login flow
        
        System.out.println("Starting Applied Jobs Page Automated Verification...");
        AppliedJobsPage appliedJobsPage = new AppliedJobsPage(driver);
        
        // Navigate
        appliedJobsPage.navigateToAppliedJobs();
        
        // Verify
        boolean isLoaded = appliedJobsPage.verifyAppliedJobsPageLoaded();
        Assert.assertTrue(isLoaded, "Applied Jobs page failed to load correctly!");
        
        // Log final test state to report
        CustomHtmlReporter.logStep("Applied Jobs Module", "EXEC_1", "Execution", "jobsModuleTest -> AppliedJobs", "PASS", "-");
    }

    @Test(priority = 2)
    public void executeJobPostVerification() {
        System.out.println("Starting Job Post Page Automated Verification...");
        JobPostPage jobPostPage = new JobPostPage(driver);
        
        // Navigate
        jobPostPage.navigateToJobPost();
        
        // Verify
        boolean isLoaded = jobPostPage.verifyJobPostPageLoaded();
        Assert.assertTrue(isLoaded, "Job Post page failed to load correctly!");
        
        // Log final test state to report
        CustomHtmlReporter.logStep("Job Post Module", "EXEC_2", "Execution", "jobsModuleTest -> JobPost", "PASS", "-");
    }
}
