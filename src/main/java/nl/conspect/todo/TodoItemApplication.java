package nl.conspect.todo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class TodoItemApplication {

  private static final System.Logger logger = System.getLogger(TodoItemApplication.class.getName());

  public static void main(String[] args) throws Exception {
    var server = HttpServer.create(new InetSocketAddress(9080), 64);
    server.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
    server.createContext("/ping", new PongHandler());
    server.createContext("/todos", new TodoItemHandler(new InMemoryTodoItemRepository())).getFilters().add(new HiddenMethodFilter());
    server.start();
    logger.log(System.Logger.Level.INFO, "Server open for i-business :).");

  }

  static class PongHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
      var msg = "Pong!".getBytes(StandardCharsets.UTF_8);
      exchange.sendResponseHeaders(200, msg.length);
      exchange.getResponseBody().write(msg);
      exchange.close();
    }
  }
}
