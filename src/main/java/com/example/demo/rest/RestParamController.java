package com.example.demo.rest;

import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/param")
public class RestParamController {

    @GetMapping("/user") // URL : /param/user?name=test
    public String userName(HttpServletRequest request) {
        String name = request.getParameter("name");
        return String.format("당신의 이름은 %s입니다.", name);
    }

    @GetMapping("/user2") // URL : /param/user2?name=test&age=12232
    public String user2(@RequestParam(value = "name", required = true) String n,
                           @RequestParam(value = "age", defaultValue = "10") int age
    ) {

        return String.format("당신의 이름은 %s고, 나이는 %d세 입니다.", n, age);
    }

    @GetMapping("/user3") // param값만을때 DTO만들어서 제어
    public String user3(UserDTO userInfo) {

        return String.format("당신의 이름은 %s고, 나이는 %d세 이고, 주소는 %s이며, 키는 %.2f cm다, 취미는 %s다.",
                userInfo.getName(), userInfo.getAge(), userInfo.getAddress(), userInfo.getHeight(), userInfo.getHobby());
    }

    @GetMapping("/user4/{userNum}") // 경로변수 가져오기
    public String user4(@PathVariable int userNum) {
        return String.format("회원번호는 %d번입니다.", userNum);
    }

    @Setter @Getter @ToString
    @NoArgsConstructor @AllArgsConstructor // Setter와 NoArgsConstructor 설정필수
    public static class UserDTO {
        private String name;
        private int age;
        private String address;
        private double height;
        private String hobby;
    }
}
