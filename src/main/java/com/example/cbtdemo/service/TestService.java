package com.example.cbtdemo.service;

import com.example.cbtdemo.controller.request.TestRequest;
import com.example.cbtdemo.dto.TestDto;

import java.util.List;

public interface TestService {
    TestDto add(TestRequest newTestRequest);

    List<TestDto> getAll();
}
