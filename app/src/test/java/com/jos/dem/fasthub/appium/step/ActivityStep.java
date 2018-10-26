package com.jos.dem.fasthub.appium.step;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;
import java.util.logging.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.AppiumDriver;

public class ActivityStep extends BaseStep {

  private AppiumDriver driver;
  private Logger log = Logger.getLogger(this.getClass().getName());

  @When("I launch the application")
  public void shouldOpenTheApplication() throws Exception {
    log.info("Running: I launch the application at " + new Date());
    driver = getDriver();
  }

  @Then("I should be able to see recent activities")
  public void shouldDisplayActivitites() throws Exception {
    log.info("Running: I should be able to see recent activities at " + new Date());
    assertNotNull(driver.findElementsByAccessibilityId("com.fastaccess.github:id/action_bar_root"));
    assertNotNull(driver.findElementsByAccessibilityId("android:id/navigationBarBackground"));
    assumeTrue(driver.findElementsByAccessibilityId("com.fastaccess.github:id/container") != null);

    log.info("ActivityStep: Container exist, let's get at least one activity");
    assertNotNull(driver.findElementsByAccessibilityId("com.fastaccess.github:id/avatar"));
    assertNotNull(driver.findElementsByAccessibilityId("com.fastaccess.github:id/title"));
    assertNotNull(driver.findElementsByAccessibilityId("com.fastaccess.github:id/date"));
  }

}
