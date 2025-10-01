package com.shakib.todo_list.services.implementation;

import com.shakib.todo_list.dto.AddTodoRequestDto;
import com.shakib.todo_list.dto.TodoDto;
import com.shakib.todo_list.entity.TodoEntity;
import com.shakib.todo_list.reporitory.TodoRepository;
import com.shakib.todo_list.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImplement implements TodoService {
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<TodoDto> getAllTodos() {
        List<TodoEntity> todos= todoRepository.findAll();
        return todos
                .stream()
                .map(todo-> new TodoDto(todo.getId(),todo.getTitle(),todo.getDescription(), todo.getIsComplete()))
                .toList();

    }

    @Override
    public TodoDto createNewStudent(AddTodoRequestDto addTodoRequestDto) {
        TodoEntity newTodo = modelMapper.map(addTodoRequestDto, TodoEntity.class);
        TodoEntity todo = todoRepository.save(newTodo);
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto updateStudent(Long id, AddTodoRequestDto addTodoRequestDto) {
        TodoEntity todo = todoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Todo not found in this id :" +id));
        modelMapper.map(addTodoRequestDto,todo);
        todo= todoRepository.save(todo);
        return modelMapper.map(todo, TodoDto.class);
    }
}
