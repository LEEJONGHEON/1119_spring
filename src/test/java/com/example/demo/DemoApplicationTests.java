package com.example.demo;

import com.example.demo.todo.entity.Todo;
import com.example.demo.todo.repository.TodoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링 컨테이너를 테스트 클래스에서 사용가능
class DemoApplicationTests {

	@Autowired
	TodoRepository repository;

	// 단언
	@Test
	@DisplayName("저장소에서 목록조회시 할일의 개수가 3개여야 한다.")
	void findAllTest() {
		// given : 테스트 시 필요한 데이터

		// when : 테스트 실제 상황
		List<Todo> todoList = repository.findAll();

		// then : 테스트 결과물 단언
		assertEquals(3,todoList.size());
		assertNotNull(todoList);
	}

	@Test
	@DisplayName("아이디가 2번인 할일 데이터 조회시 그 작성이 이름이 테스트2여야한다.")
	void findOneTest() {

		// give
		long id = 2L;

		// when
		Todo todo = repository.findOne(id);

		// then
		assertEquals("테스트2",todo.getUserId());
		assertFalse(todo.isDone());
	}

	@Test
	@DisplayName("1번 할일을 삭제한후 다시 조회했을 때 null이 나와야한다.")
	void check() {
	    // given : 테스트 시 필요한 데이터
		long id = 1L;

	    // when : 테스트 실제 상황
		boolean flag = repository.delete(id);
		Todo todo = repository.findOne(id);

	    // then : 테스트 결과물 단언
		assertTrue(flag);
		assertNull(todo);
		assertEquals(2,repository.findAll().size());
	}

	@Test
	@DisplayName("할일을 등록합니다. -> 할일 4개로 출력, 생성된 할일 조회시 null 이 아니여야합니다.")
	void create() {
	    // given : 테스트 시 필요한 데이터
		long id = 4L;
		String userid = "테스트4";
		String title = "테스트4 제목";
		boolean done = false;
		Todo todo = new Todo(id,userid,title,done);

	    // when : 테스트 실제 상황
		repository.toDoCreate(todo);

	    // then : 테스트 결과물 단언
		assertNotNull(repository.findOne(id));
		assertEquals(4,repository.findAll().size());

	}
}
