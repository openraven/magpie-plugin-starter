package org.example.plugins;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.openraven.magpie.api.MagpieEnvelope;
import io.openraven.magpie.api.TerminalPlugin;
import org.slf4j.Logger;

/*
  Starter Terminal plugin.  Terminal plugins are responsible for exporting data out of Magpie.  This example writes
  YAML to standard out, but others may write to an MQ or RDBMS.

  This particular example takes no configuration and hence has a Void configuration type.
 */
public class SampleTerminalPlugin implements TerminalPlugin<Void> {

  private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory()).findAndRegisterModules();

  public final static String ID = "exampleorg.sample.yaml";

  private Logger logger;

  @Override
  public void accept(MagpieEnvelope magpieEnvelope) {
    try {
      // We don't write to stdout directly through Jackson because it automatically closes streams after use.
      System.out.println(mapper.writeValueAsString(magpieEnvelope.getContents()));
    } catch (JsonProcessingException ex) {
      logger.warn("Failed to write YAML", ex);
    }
  }

  @Override
  public String id() {
    return ID;
  }

  @Override
  public void init(Void config, Logger logger) {
    this.logger = logger;
  }

  @Override
  public Class<Void> configType() {
    return null;
  }
}
