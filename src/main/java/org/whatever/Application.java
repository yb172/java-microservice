package org.whatever;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.whatever.rest.RestApiServer;

public class Application {

  public static void main(String[] args) {
    final Injector injector = Guice.createInjector(new Module());
    final RestApiServer server = injector.getInstance(RestApiServer.class);
    server.start(8080);
  }

}
