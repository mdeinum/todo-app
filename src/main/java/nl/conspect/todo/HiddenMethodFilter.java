package nl.conspect.todo;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HiddenMethodFilter extends Filter {

  private static final List<String> ALLOWED_METHODS = List.of("PUT", "DELETE", "PATCH");

  public static final String DEFAULT_METHOD_PARAM = "_method";

  private String methodParam = DEFAULT_METHOD_PARAM;

  @Override
  public void doFilter(HttpExchange exchange, Chain chain) throws IOException {

    var exchangeToUse = exchange;
    if ("POST".equals(exchangeToUse.getRequestMethod())) {

    }

    chain.doFilter(exchange);
  }

  @Override
  public String description() {
    return "Hidden Method Filter";
  }
}
