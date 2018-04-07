package org.whatever;

import org.whatever.rest.RestApiServer;
import dagger.Component;

@Component(modules = AppModule.class)
public interface App {
  RestApiServer server();
}
