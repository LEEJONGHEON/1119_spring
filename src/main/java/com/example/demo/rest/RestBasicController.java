package com.example.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody // 응답할떄 return으로 HTML을 보내는게아니라 JSON 데이터를 반환
public class RestBasicController {

    @GetMapping("/china")
    public List<String> food() {
        List<String> foodList
                = Arrays.asList("마파두부","꿔바로우","마라탕");

        return foodList;
    }

}
