package org.whatever.rest;

import spark.Request;
import spark.Response;

public class GoodbyeController {

  public String sayGoodbye(Request req, Response resp) {
    return "Bye, " + req.params("name");
  }

}
