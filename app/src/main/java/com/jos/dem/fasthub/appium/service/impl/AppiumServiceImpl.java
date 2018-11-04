package com.jos.dem.fasthub.appium.service.impl;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jos.dem.fasthub.appium.service.AppiumService;
import com.jos.dem.fasthub.appium.util.ConfigurationReader;

public class AppiumServiceImpl implements AppiumService {

  private File path = new File(ConfigurationReader.getProperty("application.path"));

  public void setCapabilities(DesiredCapabilities capabilities) throws IOException {
    capabilities.setCapability("deviceName", ConfigurationReader.getProperty("device.name"));
    capabilities.setCapability(CapabilityType.VERSION, ConfigurationReader.getProperty("device.version"));
    capabilities.setCapability("platformName", ConfigurationReader.getProperty("device.platform"));
    capabilities.setCapability("noReset", ConfigurationReader.getProperty("application.noreset"));
    capabilities.setCapability("app", path.getCanonicalPath());
  }

}
