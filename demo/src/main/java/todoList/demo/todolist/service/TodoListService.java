package todoList.demo.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todoList.demo.todolist.entity.CreateTodoList;
import todoList.demo.todolist.entity.TodoList;
import todoList.demo.todolist.repository.TodoListRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoListService {

    private final TodoListRepository todolistRepository;
    public TodoList createTodoList(CreateTodoList todoList){
        TodoList todoList1 = new TodoList();
        todoList1.setContent(todoList.getContent());
        TodoList save = todolistRepository.save(todoList1);
        return save;
    }
    public TodoList updateTodoList(TodoList todoList,long todolistId){
        TodoList byId = findById(todolistId);
        byId.setContent(todoList.getContent());
        TodoList save = todolistRepository.save(byId);
        return save;
    }
    public TodoList getTodoList(long todolistId){
        TodoList byId = findById(todolistId);
        return byId;
    }
    public List<TodoList> getTodoLists(){
        List<TodoList> all = todolistRepository.findAll();
        return all;
    }
    public void deleteTodoList(long todolistId){
        todolistRepository.delete(findById(todolistId));
    }

    private TodoList findById(long todolistId){
        Optional<TodoList> byId = todolistRepository.findById(todolistId);
        TodoList findId = byId.orElseThrow(() -> new RuntimeException("아이디가 존재하지 않습니다"));
        return findId;
    }
}
