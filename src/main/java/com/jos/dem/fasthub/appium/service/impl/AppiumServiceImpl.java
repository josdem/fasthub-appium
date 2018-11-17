package com.jos.dem.fasthub.appium.service.impl;

import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.jos.dem.fasthub.appium.service.AppiumService;
import com.jos.dem.fasthub.appium.util.ConfigurationReader;

@Service
public class AppiumServiceImpl implements AppiumService {

  @Value("${device.name}")
  private String deviceName;
  @Value("${device.version}")
  private String deviceVersion;
  @Value("${device.platform}")
  private String devicePlatform;
  @Value("${application.noreset}")
  private String applicationNoreset;
  @Value("${application.path}")
  private String applicationPath;

  private DesiredCapabilities capabilities = new DesiredCapabilities();

  @PostConstruct
  public void setup() throws IOException {
    File path = new File(ConfigurationReader.getProperty("application.path"));
    capabilities.setCapability("deviceName", deviceName);
    capabilities.setCapability(CapabilityType.VERSION, deviceVersion);
    capabilities.setCapability("platformName", devicePlatform);
    capabilities.setCapability("noReset", applicationNoreset);
    capabilities.setCapability("app", path.getCanonicalPath());
  }

  public DesiredCapabilities getCapabilities(){
    return capabilities;
  }

}
