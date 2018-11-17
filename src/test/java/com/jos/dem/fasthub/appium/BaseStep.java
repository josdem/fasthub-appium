package com.jos.dem.fasthub.appium;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jos.dem.fasthub.appium.service.AppiumService;
import com.jos.dem.fasthub.appium.service.impl.AppiumServiceImpl;

@ContextConfiguration(classes = FasthubAppiumApplication.class)
@WebAppConfiguration
public class BaseStep {

  @Value("${appium.server}")
  private String appiumServer;
  @Value("${appium.wait}")
  private Long appiumWait;
  @Value("${appium.timeout}")
  private Long appiumTimeout;

  @Autowired
  private AppiumService appiumService;
  private AndroidDriver<AndroidElement> driver;

  public AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {
    if(driver == null){
      driver = new AndroidDriver(new URL(appiumServer), appiumService.getCapabilities());
      driver.manage().timeouts().implicitlyWait(appiumWait, TimeUnit.SECONDS);
    }
    return driver;
  }

}

