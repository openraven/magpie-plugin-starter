package org.example.plugins;

import java.util.HashMap;
import java.util.Map;

public class SampleOriginConfig {

  private String apiKey;

  private String apiSecret;

  private Map<String, String> properties = new HashMap<>();

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getApiSecret() {
    return apiSecret;
  }

  public void setApiSecret(String apiSecret) {
    this.apiSecret = apiSecret;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }
}
