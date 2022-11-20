package com.example.demo.todo.dto;

import com.example.demo.todo.entity.Todo;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
// Data return 해줄 데이터 명세
public class TodoDto {

    private long id;
    private String title;
    private boolean done;

    public TodoDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.done = todo.isDone();
    }

}
