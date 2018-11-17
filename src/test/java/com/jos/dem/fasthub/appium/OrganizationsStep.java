package com.jos.dem.fasthub.appium;

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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;

public class OrganizationsStep extends BaseStep {

  private AndroidDriver<AndroidElement> driver;
  private Logger log = Logger.getLogger(this.getClass().getName());

  @When("I click on menu to access organizations")
  public void shouldClickOnMenu() throws Exception {
    log.info("Running: I click on menu at " + new Date());
    driver = getDriver();
    assumeTrue(driver.findElement(By.id("toolbar")) != null);

    log.info("Toolbar exist, let's get tap on it");
    driver.findElement(By.xpath("//android.widget.ImageButton[contains(@content-desc, 'Navigate up')]")).click();
  }

  @And("I click on organizations")
  public void shouldClickOnOrganizations() throws Exception {
    log.info("Running: I click on organizations at " + new Date());
    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[3]/android.widget.CheckedTextView")).click();
  }

  @Then("I should be able to see organizations")
  public void shouldAbleToSeeOrganizations() throws Exception {
    log.info("Running: I should be able to see organizations at " + new Date());
    assumeTrue(driver.findElement(By.id("recycler")) != null);
    assertNotNull(driver.findElement(By.id("avatarLayout")));
    assertNotNull(driver.findElement(By.id("title")));
  }

  @And("I should be able to go back from organizations")
  public void shouldBeAbleToGoBack() throws Exception {
    log.info("Running: I should be able to go back at " + new Date());
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
  }

}

