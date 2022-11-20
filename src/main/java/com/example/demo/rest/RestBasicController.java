package com.example.demo.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.HttpConstraint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
//@ResponseBody // 응답할떄 return으로 HTML을 보내는게아니라 JSON 데이터를 반환
public class RestBasicController {

    @GetMapping("/china")
    public List<String> food() {
        List<String> foodList
                = Arrays.asList("마파두부","꿔바로우","마라탕");

        return foodList;
    }

    @GetMapping("/hobby")
    public Map<String, String> hobbies() {
        Map<String, String> hobbies = new HashMap<>();
        hobbies.put("운동","축구");
        hobbies.put("여가","산책");
        hobbies.put("맛집","한우");
        return hobbies;
    }

    @GetMapping("/score")
    public Score score() {
        return new Score("김철수",99,50,'8');
    }

    @GetMapping("/score-list")
    public List<Score> scoreList() {
        return Arrays.asList(
                new Score("김철수1",99,50,'8'),
                new Score("김철수2",89,60,'7'),
                new Score("김철수3",79,70,'6')
        );
    }
    @Setter @Getter @ToString
    @AllArgsConstructor
    public static class Score {

        private String name;
        private int javaExam;
        private int mathExam;
        private char grade;

    }

}
