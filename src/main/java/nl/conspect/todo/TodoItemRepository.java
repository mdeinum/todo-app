package nl.conspect.todo;

import java.util.List;
import java.util.Optional;

public interface TodoItemRepository {

  TodoItem save(TodoItem todo);
  Optional<TodoItem> findById(Long id);
  List<TodoItem> findAll();
}
