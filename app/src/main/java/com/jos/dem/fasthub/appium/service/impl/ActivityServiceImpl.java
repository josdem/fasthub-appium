package com.jos.dem.fasthub.appium.service.impl;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jos.dem.fasthub.appium.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {

  private File path = new File("src/main/res/app-release.apk");

  public void setCapabilities(DesiredCapabilities capabilities) throws IOException {
    capabilities.setCapability("deviceName", "Pixel 2");
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
    capabilities.setCapability(CapabilityType.VERSION, "9.0");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("noReset","true");
    capabilities.setCapability("app", path.getCanonicalPath());
  }

}
