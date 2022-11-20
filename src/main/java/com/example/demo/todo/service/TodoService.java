package com.example.demo.todo.service;


import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.Todo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 역활 controller와 repository 사이의 로직 처리
@Service
@Slf4j
@RequiredArgsConstructor // 생성자 할당
public class TodoService {

    private final TodoRepository repository;

    /*
       할일 목록 조회
       1. 컨트롤러에서 유저아이디를 뺀 할일 리스트를 전달
       2. 할일 목록에 카운트를 세서 따로 추가해서 전달
     */


    public FindAllDTO findAllResult() {
        List<Todo> todoList = repository.findAll(); // DB에서 데이터가져오기

        return new FindAllDTO(todoList); // DB에서 가져온 데이터 로직 결과값 반환
    }

    public FindAllDTO createServ(final Todo newTodo) {
        if (newTodo == null) {
            log.warn("입력 값이 없습니다.");
            throw new RuntimeException("에러");
        }

        boolean flag = repository.toDoCreate(newTodo);
        if (flag) log.info("새로운 할일 [id: {}]이 저장되었습니다.", newTodo.getId());

        return flag ? findAllResult() : null;
    }

    public Todo findService(Long id) {
        return repository.findOne(id);
    }

    public FindAllDTO deleteService(Long id) {
        boolean flag = repository.delete(id);
        if (!flag) {
            log.warn("delete fail not found id [{}]",id);
            throw new RuntimeException("delete fail");
        }
        return this.findAllResult();
    }

}
