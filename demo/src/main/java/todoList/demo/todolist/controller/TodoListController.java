package todoList.demo.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoList.demo.todolist.entity.CreateTodoList;
import todoList.demo.todolist.entity.TodoList;
import todoList.demo.todolist.service.TodoListService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo-list")
@CrossOrigin
public class TodoListController {

    private final TodoListService todoListService;

    @PostMapping
    public ResponseEntity createTodoList(@RequestBody CreateTodoList todoList){
        TodoList createdTodoList = todoListService.createTodoList(todoList);
        return new ResponseEntity(createdTodoList, HttpStatus.CREATED);
    }

    @GetMapping("/{listId}")
    public ResponseEntity getTodoList(@PathVariable("listId")long listId){
        TodoList getTodoList = todoListService.getTodoList(listId);
        return new ResponseEntity(getTodoList, HttpStatus.OK);
    }
    @PatchMapping("/{listId}")
    public ResponseEntity updateTodoList(@PathVariable("listId") long listId,
                                         @RequestBody TodoList todoList){
        TodoList updatedTodoList = todoListService.updateTodoList(todoList,listId);
        return new ResponseEntity(updatedTodoList, HttpStatus.OK);
    }
    @DeleteMapping("/{listId}")
    public ResponseEntity deleteTodoList(@PathVariable("listId") long todoListId){
        todoListService.deleteTodoList(todoListId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}

