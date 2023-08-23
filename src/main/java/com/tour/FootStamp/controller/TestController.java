package com.tour.FootStamp.controller;

import com.tour.FootStamp.model.aws.dto.portfolio;
import com.tour.FootStamp.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;

    @GetMapping("/hello2")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/test")
    public List<portfolio> test() {

        return testService.getAllDataList();
    }
}