package com.jos.dem.fasthub.appium;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PullRequestStep extends BaseStep {

  private AndroidDriver<AndroidElement> driver;
  private Logger log = Logger.getLogger(this.getClass().getName());

  @When("I click on pull requests")
  public void shouldClickOnIssues() throws Exception {
    log.info("Running: I click on pull requests at " + new Date());
    driver = getDriver();
    assumeTrue(driver.findElement(By.id("bottomNavigation")) != null);

    log.info("PullRequestStep: Pull requests button exist, let's get tap on it");
    driver.findElement(By.xpath("//android.view.View[contains(@resource-id, 'pullRequests')]")).click();
  }

  @Then("I should be able to see pull requests")
  public void shouldDisplayIssues() throws Exception {
    log.info("Running: I should be able to see pull requests at " + new Date());
    assumeTrue(driver.findElement(By.id("recycler")) != null);

    log.info("PullRequestStep: Container exist, let's get a pull request if any");
    assumeTrue(driver.findElement(By.id("empty_text")) != null);
    assertNotNull(driver.findElement(By.id("reload")));
  }

}
