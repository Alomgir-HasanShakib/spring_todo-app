package com.shakib.todo_list.services;

import com.shakib.todo_list.dto.AddTodoRequestDto;
import com.shakib.todo_list.dto.TodoDto;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

public interface TodoService {
    List<TodoDto> getAllTodos();

    TodoDto updateTodo(Long id, AddTodoRequestDto addTodoRequestDto);

    TodoDto createNewTodo(@Valid AddTodoRequestDto addTodoRequestDto);

    TodoDto updateSpecificTodoField(Long id, Map<String, Object> updates);
}
