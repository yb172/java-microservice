package org.whatever;

public class AppLauncher {

  public static void main(String[] args) {
    App app = DaggerApp.create();
    app.server().start(8080);
  }

}
