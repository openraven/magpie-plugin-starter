package org.example.plugins;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.openraven.magpie.api.Emitter;
import io.openraven.magpie.api.MagpieEnvelope;
import io.openraven.magpie.api.OriginPlugin;
import io.openraven.magpie.api.Session;
import org.slf4j.Logger;

import java.util.List;

/*
  Starter Origin (discovery) plugin.  Origin plugins should provide their own logic to iterate over a cloud provider's
  infrastructure and emit them down the Magpie pipeline.
 */
public class SampleOriginPlugin implements OriginPlugin<SampleOriginConfig> {

  private final ObjectMapper mapper = Utils.objectMapper();

  public final static String ID = "exampleorg.sample.discovery";

  private SampleOriginConfig config;
  private Logger logger;

  @Override
  public void discover(Session session, Emitter emitter) {
    // Perform provider-specific discovery here and emit JSON trees of discovered assets. The second field (list of
    // plugin paths) is formatted as <pluginID>:<serviceType>.  For example: "exampleorg.sample.discovery:compute". This
    // allows downstream plugins to act based on the plugin and service types.
    emitter.emit(new MagpieEnvelope(session, List.of(ID  + ":<serviceName>"), mapper.createObjectNode() /*Empty tree as an example*/));
  }

  @Override
  public String id() {
    return ID;
  }

  @Override
  public void init(SampleOriginConfig config, Logger logger) {
    this.config = config;
    this.logger = logger;
  }

  @Override
  public Class<SampleOriginConfig> configType() {
    return SampleOriginConfig.class;
  }
}
