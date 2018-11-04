package com.jos.dem.fasthub.appium.step;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.AppiumDriver;

public class IssueStep extends BaseStep {

  private AppiumDriver driver;
  private Logger log = Logger.getLogger(this.getClass().getName());

  @When("I click on issue")
  public void shouldClickOnIssues() throws Exception {
    log.info("Running: I click on issue at " + new Date());
    driver = getDriver();
    assumeTrue(driver.findElementsByAccessibilityId("com.fastaccess.github:id/bottomNavigation") != null);

    log.info("IssueStep: Issue button exist, let's get tap on it");
    List<WebElement> elements = driver.findElementsByAccessibilityId("com.fastaccess.github:id/pinned");
    elements.forEach(it -> log.info("element: " + it));
  }

  @Then("I should be able to see issues")
  public void shouldDisplayIssues() throws Exception {
    log.info("Running: I should be able to see issues at " + new Date());
    assumeTrue(driver.findElementsByAccessibilityId("com.fastaccess.github:id/pager") != null);

    log.info("IssueStep: Container exist, let's get at least one issue");
    assertNotNull(driver.findElementsByAccessibilityId("com.fastaccess.github:id/title"));
    assertNotNull(driver.findElementsByAccessibilityId("com.fastaccess.github:id/details"));
  }

}