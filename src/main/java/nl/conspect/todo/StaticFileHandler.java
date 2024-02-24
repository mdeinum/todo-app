package nl.conspect.todo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

public class StaticFileHandler implements HttpHandler {
  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (exchange.getRequestMethod().equals("GET")) {
      var file = exchange.getRequestURI();
    }
    exchange.close();
  }
}
