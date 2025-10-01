package com.shakib.todo_list.reporitory;

import com.shakib.todo_list.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
