package todoList.demo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todoList.demo.todolist.entity.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
