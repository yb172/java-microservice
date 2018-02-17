package integration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.rules.ExternalResource;
import org.whatever.Module;
import org.whatever.rest.RestApiServer;

public class TestRestApi extends ExternalResource {
  private RestApiServer server;
  private String urlPrefix;

  @Override
  protected void before() throws Throwable {
    final Injector injector = Guice.createInjector(new Module());
    server = injector.getInstance(RestApiServer.class);
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
