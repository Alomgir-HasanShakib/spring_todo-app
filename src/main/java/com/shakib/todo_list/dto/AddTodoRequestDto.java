package com.shakib.todo_list.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTodoRequestDto {
    @NotBlank(message = "Title is Required")
    private String title;

    @NotBlank(message = "Description is required.")
    private String description;
    private boolean isComplete;

}
