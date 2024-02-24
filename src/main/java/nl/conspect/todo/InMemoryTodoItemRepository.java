package nl.conspect.todo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class InMemoryTodoItemRepository implements TodoItemRepository {

  private final ConcurrentMap<Long, TodoItem> todoItems = new ConcurrentHashMap<>();

  @Override
  public TodoItem save(TodoItem todo) {
    return todoItems.put(todo.id(), todo);
  }

  @Override
  public Optional<TodoItem> findById(Long id) {
    return Optional.ofNullable(todoItems.get(id));
  }

  @Override
  public List<TodoItem> findAll() {
    return List.copyOf(todoItems.values());
  }
}
