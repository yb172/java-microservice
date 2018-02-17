package integration.hello;

import com.jcabi.http.request.JdkRequest;
import org.assertj.core.api.WithAssertions;
import org.junit.Rule;
import org.junit.Test;
import integration.TestRestApi;

public class GoodbyeApiTest implements WithAssertions {

  @Rule
  public TestRestApi api = new TestRestApi();

  @Test
  public void testGoodbye() throws Exception {
    String response = new JdkRequest(api.url("/goodbye/Spring")).fetch().body();
    assertThat(response).isEqualToIgnoringCase("Bye, Spring");
  }
}
