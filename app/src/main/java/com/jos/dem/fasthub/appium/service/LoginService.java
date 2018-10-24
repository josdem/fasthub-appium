package com.jos.dem.fasthub.appium.service;

import java.io.IOException;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface LoginService {
  void setCapabilities(DesiredCapabilities capabilities) throws IOException;
}
