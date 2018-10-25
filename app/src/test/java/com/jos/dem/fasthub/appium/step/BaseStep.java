package com.jos.dem.fasthub.appium.step;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

import com.jos.dem.fasthub.appium.service.AppiumService;
import com.jos.dem.fasthub.appium.service.impl.AppiumServiceImpl;

public class BaseStep {

  private static AppiumDriver<WebElement> driver;
  private static DesiredCapabilities capabilities = new DesiredCapabilities();
  private static AppiumService appiumService = new AppiumServiceImpl();

  public static AppiumDriver<WebElement> getDriver() throws IOException {
    if(driver == null){
      appiumService.setCapabilities(capabilities);
      driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    return driver;
  }

}

