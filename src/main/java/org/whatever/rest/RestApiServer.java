package org.whatever.rest;

import javax.inject.Inject;

import spark.Service;

public class RestApiServer implements AutoCloseable {

  private final HelloController helloController;
  private final GoodbyeController goodbyeController;
  private final Service server;

  @Inject
  public RestApiServer(
      final HelloController helloController,
      final GoodbyeController goodbyeController) {
    this.helloController = helloController;
    this.goodbyeController = goodbyeController;
    this.server = Service.ignite();
  }

  public RestApiServer start(int port) {
    server.port(port);
    defineRoutes();
    return this;
  }

  public RestApiServer waitUntilStarted() {
    server.awaitInitialization();
    return this;
  }

  public int getPort() {
    return server.port();
  }

  private void defineRoutes() {
    server.get("/hello", helloController::sayHello);

    server.get("/goodbye/:name", goodbyeController::sayGoodbye);
  }

  @Override
  public void close() {
    server.stop();
  }
}
