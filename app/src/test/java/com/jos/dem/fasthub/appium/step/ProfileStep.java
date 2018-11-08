package com.jos.dem.fasthub.appium.step;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class ProfileStep extends BaseStep {

  private AppiumDriver<AndroidElement> driver;
  private Logger log = Logger.getLogger(this.getClass().getName());

  @When("I click on menu")
  public void shouldClickOnMenu() throws Exception {
    log.info("Running: I click on menu at " + new Date());
    driver = getDriver();
    assumeTrue(driver.findElement(By.id("toolbar")) != null);

    log.info("PullRequestStep: Toolbar exist, let's get tap on it");
    driver.findElement(By.xpath("//android.widget.ImageButton[contains(@content-desc, 'Navigate up')]")).click();
  }

  @And("I click on profile")
  public void shouldClickOnProfile() throws Exception {
    log.info("Running: I click on profile");
    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[2]")).click();
  }

  @Then("I should be able to see avatar")
  public void shouldAbleToSeeAvatar() throws Exception {
    log.info("Running: I should be able to see avatar at " + new Date());
    assertNotNull(driver.findElement(By.id("avatar")));
  }

  @And("I should be able to see name")
  public void shouldAbleToSeeFullname() throws Exception {
    log.info("Running: I should be able to see name at " + new Date());
    assertNotNull(driver.findElement(By.id("fullname")));
  }

  @And("I should be able to see username")
  public void shouldAbleToSeeUsername() throws Exception {
    log.info("Running: I should be able to see username at " + new Date());
    assertNotNull(driver.findElement(By.id("username")));
  }

  @And("I should be able to see description")
  public void shouldAbleToSeeDescription() throws Exception {
    log.info("Running: I should be able to see description at " + new Date());
    assertNotNull(driver.findElement(By.id("description")));
  }

}
