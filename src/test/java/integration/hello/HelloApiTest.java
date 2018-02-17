package integration.hello;

import com.jcabi.http.request.JdkRequest;
import org.assertj.core.api.WithAssertions;
import org.junit.Rule;
import org.junit.Test;
import integration.TestRestApi;

public class HelloApiTest implements WithAssertions {
  @Rule
  public TestRestApi api = new TestRestApi();

  @Test
  public void testHello() throws Exception {
    String response = new JdkRequest(api.url("/hello")).fetch().body();
    assertThat(response).isEqualToIgnoringCase("Hello world");
  }
}
