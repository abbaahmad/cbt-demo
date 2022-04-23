package com.example.cbtdemo.service.impl;

import com.example.cbtdemo.controller.request.TestRequest;
import com.example.cbtdemo.dto.TestDto;
import com.example.cbtdemo.dto.mapper.QuestionMapper;
import com.example.cbtdemo.dto.mapper.TestMapper;
import com.example.cbtdemo.model.Question;
import com.example.cbtdemo.model.Test;
import com.example.cbtdemo.model.TestTaker;
import com.example.cbtdemo.repository.QuestionRepository;
import com.example.cbtdemo.repository.ResponseRepository;
import com.example.cbtdemo.repository.TestRepository;
import com.example.cbtdemo.repository.TestTakerRepository;
import com.example.cbtdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TestTakerRepository testTakerRepository;

    @Autowired
    ResponseRepository responseRepository;

    @Override
    @Transactional
    public TestDto add(TestRequest newTestRequest) {
        Test test = TestMapper.toTest(newTestRequest);
        Set<Question> questions = newTestRequest.getQuestions()
                .stream().map(QuestionMapper::toQuestion)
                .collect(Collectors.toUnmodifiableSet());
        test.setQuestions(questions);
        Test savedTest = testRepository.save(test);
        return TestMapper.toDto(savedTest);
    }

    @Override
    public List<TestDto> getAll() {
        return testRepository.findAll()
                .stream().map(TestMapper::toDto).toList();
    }
}
