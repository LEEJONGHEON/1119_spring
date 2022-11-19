package com.example.demo.todo.repository;

import com.example.demo.todo.entity.Todo;
import org.springframework.stereotype.Component;

import java.util.List;

// 역활 : Todo List 데이터 CRUD 작업처리

public interface TodoRepository {

    // ===========조회 기능============

    // 할일 전체조회
    // return Todo List 반환
    List<Todo> findAll();

    // 할일 개별 조회
    // @params id
    // return Todo
    Todo findOne(long id);


    // ===========생성 기능=============

    /*
    할 일 생성 기능
    @param todo - 받아서 할일생성
    @return - 성공여부 반환
    */
    boolean toDoCreate(Todo todo);

    // ==========업데이트 기능=============
    void update();


    // ============삭제 기능================

    // 특정 할일 하나삭제
    // @param 할 일 식별자 id
    // @return 성공여부
    boolean delete(long id);
}
