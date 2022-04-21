package com.example.cbtdemo.controller.api;

import com.example.cbtdemo.controller.request.TestRequest;
import com.example.cbtdemo.dto.TestDto;
import com.example.cbtdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TestDto add(@Valid @RequestBody TestRequest newTestRequest){
        return testService.add(newTestRequest);
    }

    @GetMapping
    public List<TestDto> get(){
        return testService.getAll();
    }
}
