package com.shakib.todo_list.controller;


import com.shakib.todo_list.dto.AddTodoRequestDto;
import com.shakib.todo_list.dto.TodoDto;
import com.shakib.todo_list.services.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoDto>> getTodo(){
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody @Valid AddTodoRequestDto addTodoRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createNewTodo(addTodoRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody AddTodoRequestDto addTodoRequestDto){
        return ResponseEntity.ok(todoService.updateTodo(id,addTodoRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoDto> updateSpecificTodoField(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(todoService.updateSpecificTodoField(id,updates));
    }

}
