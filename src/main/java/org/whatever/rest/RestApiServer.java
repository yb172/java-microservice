package org.whatever.rest;

import static spark.Spark.*;

import javax.inject.Inject;

public class RestApiServer implements AutoCloseable {

  private final HelloController helloController;
  private final GoodbyeController goodbyeController;

  @Inject
  public RestApiServer(
      final HelloController helloController,
      final GoodbyeController goodbyeController) {
    this.helloController = helloController;
    this.goodbyeController = goodbyeController;
  }

  public RestApiServer start(int port) {
    port(port);
    defineRoutes();
    return this;
  }

  public RestApiServer waitUntilStarted() {
    awaitInitialization();
    return this;
  }

  public int getPort() {
    return port();
  }

  private void defineRoutes() {
    get("/hello", helloController::sayHello);

    get("/goodbye/:name", goodbyeController::sayGoodbye);
  }

  @Override
  public void close() {
    stop();
  }
}
