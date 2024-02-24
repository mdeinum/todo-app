package nl.conspect.todo;

public final class HtmlTemplates {

  public static final StringTemplate.Processor<String, RuntimeException> LAYOUT = StringTemplate.Processor.of( (st) -> {
    var sb = new StringBuilder();
    for (var fragment : st.fragments()) {
      sb.append(fragment);
    }
    var content =  sb.toString();
    return STR."""
        <html>
          <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>TodoMVC - No Java Frameworks</title>
            <link href="https://cdn.jsdelivr.net/npm/todomvc-app-css@2.4.3/index.min.css" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/todomvc-common@1.0.5/base.min.js"></script>
            <link href="https://cdn.jsdelivr.net/npm/todomvc-common@1.0.5/base.min.css" rel="stylesheet">
          </head>
          <body>
          <section class="todoapp">
              <header class="header">
                  <h1>todos</h1>
                  <form method="post" action="/todo>
                      <input id="title" class="new-todo" placeholder="What needs to be done?" autofocus>
                  </form>
              </header>
            <section class="main">
              \{content}
            </section>
          </body>
        </html>
        """;
  });

}
