package com.jos.dem.fasthub.appium.step;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.AppiumDriver;

import com.jos.dem.fasthub.appium.service.ActivityService;
import com.jos.dem.fasthub.appium.service.impl.ActivityServiceImpl;

public class ActivityStep {

  private AppiumDriver driver;
  private DesiredCapabilities capabilities = new DesiredCapabilities();
  private ActivityService activityService = new ActivityServiceImpl();

  private Logger log = Logger.getLogger(this.getClass().getName());

  @Before
  public void setup() throws Exception {
    activityService.setCapabilities(capabilities);
  }

  @When("I launch the application")
  public void shouldOpenTheApplication() throws Exception {
    log.info("Running: I launch the application at " + new Date());
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Then("I should be able to see recent activities")
  public void shouldDisplayCategories() throws Exception {
    log.info("Running: I should be able to see recent activities at " + new Date());
    assertNotNull(driver.findElementsByAccessibilityId("com.fastaccess.github:id/action_bar_root"));
    assertNotNull(driver.findElementsByAccessibilityId("android:id/navigationBarBackground"));
    assumeTrue(driver.findElementsByAccessibilityId("com.fastaccess.github:id/container") != null);
    log.info("ActivityStep: container exist, let's review activities");
    assertNotNull(driver.findElementsByAccessibilityId("com.fastaccess.github:id/avatar"));
  }

  @After
  public void end(){
    driver.quit();
  }

}
