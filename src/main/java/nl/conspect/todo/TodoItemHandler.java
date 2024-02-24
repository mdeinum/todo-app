package nl.conspect.todo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class TodoItemHandler implements HttpHandler {

  private final TodoItemRepository todoItems;

  public TodoItemHandler(TodoItemRepository todoItems) {
    this.todoItems = todoItems;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    switch (exchange.getRequestMethod()) {
      case "GET": handleGet(exchange);
      case "POST": handlePost(exchange);
      case "PUT": handlePut(exchange);
      case "DELETE": handleDelete(exchange);
    }
  }

  private void handleDelete(HttpExchange exchange) {

  }

  private void handlePut(HttpExchange exchange) {

  }

  private void handlePost(HttpExchange exchange) {

  }

  private void handleGet(HttpExchange exchange) throws IOException {
    var items = todoItems.findAll();
    var response = HtmlTemplates.LAYOUT."""
        Hello World!
        """;
    exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
    exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));
    exchange.close();
  }
}
