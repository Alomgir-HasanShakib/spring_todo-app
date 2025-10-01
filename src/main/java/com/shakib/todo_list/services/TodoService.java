package com.shakib.todo_list.services;

import com.shakib.todo_list.dto.AddTodoRequestDto;
import com.shakib.todo_list.dto.TodoDto;
import jakarta.validation.Valid;

import java.util.List;

public interface TodoService {
    List<TodoDto> getAllTodos();

    TodoDto createNewStudent(@Valid AddTodoRequestDto addTodoRequestDto);
}
