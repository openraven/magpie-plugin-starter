package org.example.plugins;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.openraven.magpie.api.Emitter;
import io.openraven.magpie.api.IntermediatePlugin;
import io.openraven.magpie.api.MagpieEnvelope;
import io.openraven.magpie.api.OriginPlugin;
import io.openraven.magpie.api.Session;
import org.slf4j.Logger;

import java.util.List;

/*
  Starter Intermediate plugin.  Intermediate plugins perform functions such as schema transformations and filtering.
 */
public class SampleIntermediatePlugin implements IntermediatePlugin<SampleIntermediateConfig> {

  public final static String ID = "exampleorg.sample.filter";

  private SampleIntermediateConfig config;
  private Logger logger;

  @Override
  public void accept(MagpieEnvelope env, Emitter emitter) {
    // Perform transform or filter actions here
    emitter.emit(MagpieEnvelope.of(env, ID, env.getContents()));
  }

  @Override
  public String id() {
    return ID;
  }

  @Override
  public void init(SampleIntermediateConfig config, Logger logger) {
    this.config = config;
    this.logger = logger;
  }

  @Override
  public Class<SampleIntermediateConfig> configType() {
    return SampleIntermediateConfig.class;
  }
}
