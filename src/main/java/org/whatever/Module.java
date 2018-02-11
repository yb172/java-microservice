package org.whatever;

import com.google.inject.AbstractModule;
import org.whatever.rest.RestApiServer;

public class Module extends AbstractModule {

  @Override
  protected void configure() {
    bind(RestApiServer.class);
  }
}
