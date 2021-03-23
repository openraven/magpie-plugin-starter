package org.example.plugins;

import java.util.HashMap;
import java.util.Map;

public class SampleIntermediateConfig {

  private Map<String, String> properties = new HashMap<>();

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }
}
