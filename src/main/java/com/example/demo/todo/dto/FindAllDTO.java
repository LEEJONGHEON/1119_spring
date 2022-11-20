package com.example.demo.todo.dto;

import com.example.demo.todo.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
// 전체 목록 보여줄때 필요한 데이터 정의
public class FindAllDTO {

    private int count; // 할 일 목록 개수
    private List<TodoDto> todoList; // userID가 빠진 할일 목록

    public FindAllDTO(List<Todo> todoList) {
        this.count = todoList.size();
        this.convertDtoList(todoList);
    }

    // List<Todo>를 받으면 List<TodoDto>로 변한하는 메서드
    public void convertDtoList(List<Todo> todoList) {
        List<TodoDto> dtoList = new ArrayList<>();

        // ctrl alt n : inline화
        for(Todo todo : todoList) {
            dtoList.add(new TodoDto(todo));
        }

        this.todoList = dtoList;
    }

}
