package integration.hello;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jcabi.http.request.JdkRequest;
import org.assertj.core.api.WithAssertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whatever.Module;
import org.whatever.rest.RestApiServer;

public class HelloApiTest implements WithAssertions {
  private static RestApiServer server;

  @BeforeClass
  public static void setUp() {
    final Injector injector = Guice.createInjector(new Module());
    server = injector.getInstance(RestApiServer.class);
    server.start(8080).waitUntilStarted();
  }

  @Test
  public void testHello() throws Exception {
    String response = new JdkRequest("http://localhost:8080/hello").fetch().body();
    assertThat(response).isEqualToIgnoringCase("Hello world");
  }

  @AfterClass
  public static void tearDown() {
    server.close();
  }
}
