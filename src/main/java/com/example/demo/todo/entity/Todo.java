package com.example.demo.todo.entity;

import lombok.*;

// 역활 : 하나의 할일 데이터의 집합 객체
// lombok 라이브러리가 자동으로 해당기능들 구현해줌
// Entity Todo : DB에 저장할 데이터 상세
@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private long id;// 할 일 식별 고유 ID
    private String userId;// 할 일 등록한 회원의 식별자
    private String title;// 할 일 내용
    private boolean done;// 할 일 완료 여부


}
