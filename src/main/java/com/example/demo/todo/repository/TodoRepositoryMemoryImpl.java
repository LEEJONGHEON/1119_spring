package com.example.demo.todo.repository;

import com.example.demo.todo.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;
// 역활 : 할 일 데이터를 메모리에 CRUD
@Repository
public class TodoRepositoryMemoryImpl implements TodoRepository {

    // 메모리 저장소
    /*
     key : 할일 식별 ID, value : Todo 할일 객체
     */
    private static final Map<Long, Todo> todoMap = new HashMap<>(); // static 동일 객체하나공유

    static {
        todoMap.put(1L, new Todo(1L, "테스트1", "테스트 내용1", false));
        todoMap.put(2L, new Todo(2L, "테스트2", "테스트 내용2", false));
        todoMap.put(3L, new Todo(3L, "테스트3", "테스트 내용3", true));
    }

    @Override
    public List<Todo> findAll() {
        if (todoMap.isEmpty()) return null;
        List<Todo> todoList = new ArrayList<>();

        for (Long id : todoMap.keySet()) {
            Todo todo = todoMap.get(id);
            todoList.add(todo);
        }
        return todoList;
    }

    @Override
    public Todo findOne(long id) {
        return todoMap.get(id);
    }

    @Override
    public boolean toDoCreate(Todo todo) {
        if (todo == null) return false;
        todoMap.put(todo.getId(), todo);
        return true;
    }

    @Override
    public void update() {

    }

    @Override
    public boolean delete(long id) {
        Todo todo = todoMap.remove(id);
        return todo != null;
    }

}
