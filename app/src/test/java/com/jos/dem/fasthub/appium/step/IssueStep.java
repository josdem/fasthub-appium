package com.jos.dem.fasthub.appium.step;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class IssueStep extends BaseStep {

  private AppiumDriver<AndroidElement> driver;
  private Logger log = Logger.getLogger(this.getClass().getName());

  @When("I click on issues")
  public void shouldClickOnIssues() throws Exception {
    log.info("Running: I click on issues at " + new Date());
    driver = getDriver();
    assumeTrue(driver.findElement(By.id("bottomNavigation")) != null);

    log.info("IssueStep: Issue button exist, let's get tap on it");
    driver.findElement(By.xpath("//android.view.View[contains(@resource-id, 'pinned')]")).click();
  }

  @Then("I should be able to see issues")
  public void shouldDisplayIssues() throws Exception {
    log.info("Running: I should be able to see issues at " + new Date());
    assumeTrue(driver.findElement(By.id("pager")) != null);

    log.info("IssueStep: Container exist, let's get at least one issue");
    assertNotNull(driver.findElement(By.id("title")));
    assertNotNull(driver.findElement(By.id("details")));
  }

}
