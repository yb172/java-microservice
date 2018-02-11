package org.whatever.rest;

import spark.Request;
import spark.Response;

public class HelloController {

  public String sayHello(Request req, Response resp) {
    return "Hello world";
  }
}
