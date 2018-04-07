package integration;

import org.junit.rules.ExternalResource;
import org.whatever.App;
import org.whatever.DaggerApp;
import org.whatever.rest.RestApiServer;

public class TestRestApi extends ExternalResource {
  private RestApiServer server;
  private String urlPrefix;

  @Override
  protected void before() throws Throwable {
    App app = DaggerApp.create();
    server = app.server();
    server.start(0).waitUntilStarted();

    urlPrefix = "http://localhost:" + server.getPort();
  }

  @Override
  protected void after() {
    server.close();
  }

  public String url(String path) {
    return urlPrefix + path;
  }

}
