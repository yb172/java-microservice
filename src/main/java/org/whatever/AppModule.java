package org.whatever;

import org.whatever.rest.GoodbyeController;
import org.whatever.rest.HelloController;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

  @Provides
  static HelloController provideHelloController() {
    return new HelloController();
  }

  @Provides
  static GoodbyeController provideGoodbyeController() {
    return new GoodbyeController();
  }
}
