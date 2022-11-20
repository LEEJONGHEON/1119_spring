package com.example.demo.todo.entity;

import lombok.*;

// 역활 : 하나의 할일 데이터의 집합 객체
// lombok 라이브러리가 자동으로 해당기능들 구현해줌
// Entity Todo : DB에 저장할 데이터 상세
@Setter @Getter @ToString
@AllArgsConstructor // 전체생성자
public class Todo {

    private long id;// 할 일 식별 고유 ID
    private String userId;// 할 일 등록한 회원의 식별자
    private String title;// 할 일 내용
    private boolean done;// 할 일 완료 여부

    // 일련 번호
    private static long seq; // 모든 객체가 동일 값 공유

    //Alt insert : 생성자 생성
    //Spirng 자동으로 의존성 주입할때 기본생성자 호출하므로
    // 다른 생성자에서 기본값 할당시 값 들어가지 않음
    public Todo() {
        this.id = ++seq;
    }

    public Todo(String title) {
        this(); // 생성자 호출
        this.title = title;
        this.userId = "noname";
    }

}
