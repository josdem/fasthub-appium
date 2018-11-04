package com.jos.dem.fasthub.appium.step;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import com.jos.dem.fasthub.appium.util.ConfigurationReader;
import com.jos.dem.fasthub.appium.service.AppiumService;
import com.jos.dem.fasthub.appium.service.impl.AppiumServiceImpl;

public class BaseStep {

  private static AppiumDriver<AndroidElement> driver;
  private static DesiredCapabilities capabilities = new DesiredCapabilities();
  private static AppiumService appiumService = new AppiumServiceImpl();

  public static AppiumDriver<AndroidElement> getDriver() throws IOException {
    if(driver == null){
      appiumService.setCapabilities(capabilities);
      driver = new AppiumDriver(new URL(ConfigurationReader.getProperty("appium.server")), capabilities);
      driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigurationReader.getProperty("appium.wait")), TimeUnit.SECONDS);
    }
    return driver;
  }

}

