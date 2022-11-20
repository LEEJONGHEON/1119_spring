package com.example.demo.todo.api;

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.Todo;
import com.example.demo.todo.repository.TodoRepository;
import com.example.demo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoApiController {

    private final TodoService service;

    // field, setter , constructor(생성자) 로 할당가능
    // 프로그램 실행중에 값 변동 막기위해 생성자로 할당

    // 목록 전체 조회 GET
    @GetMapping
    public ResponseEntity<?> getTodoList() {
        log.info("/api/todos GET request");
        return ResponseEntity.ok().body(service.findAllResult());
    }

    // 할 일 목록 등록 요청
    // 생성후 생성 된 뒤 갱신된 목록 반환
    @PostMapping
    // error 상황에서는 200 나가면안됨 ResponseEntity를 반환값(상태값 반환을 위한)으로 리턴
    public ResponseEntity<?> CreateTodo(@RequestBody Todo newTodo) {
        newTodo.setUserId("noname");
        log.info("/api/todos POST request - {}",newTodo);

        try {
            FindAllDTO dto = service.createServ(newTodo);

            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);
        } catch(RuntimeException e) { // 에러 상황
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    }
