package com.example.demo.rest;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/json")
@Slf4j // 로깅 라이브러리
public class RestJsonController {

    /*
        로그 레벨

        TRACE : 서버 실행되는 발생하는 내용 로깅
        DEBUG : 개발시 확인할 내용들 로깅
        INFO : 운영시 필요한 내용들 로깅
        WARN : 경고성 상황 로깅
        ERROR : 심각한 에러 로깅
     */
    @PostMapping("/major")
    public List<String> major(@RequestBody List<String> majorList) {
        log.debug("/json/major POST request - {}", majorList);
        return null;
    }

    @PutMapping("/bbs")
    public Article test(@RequestBody Article article) {
        log.info("/json/bbs PUT Requests - {} ", article);
        return article;
    }

    @DeleteMapping("/bbs-list")
    public void bbsList(@RequestBody List<Article> list) {
        log.info("/json/bbs-list DELETE Requests - {} ", list);
    }

    @Getter @Setter @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Article {

        private long id;
        private String title;
        private String content;
        private String writer;

    }
}
