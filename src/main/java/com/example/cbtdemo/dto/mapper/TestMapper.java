package com.example.cbtdemo.dto.mapper;

import com.example.cbtdemo.controller.request.TestRequest;
import com.example.cbtdemo.dto.QuestionDto;
import com.example.cbtdemo.dto.TestDto;
import com.example.cbtdemo.model.Question;
import com.example.cbtdemo.model.Test;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;


public class TestMapper {
//    public static Test toTest(TestRequest newTestRequest){
//        Set<Question> questions = newTestRequest.getQuestions()
//                .stream().map(QuestionMapper::toQuestion)
//                .collect(Collectors.toUnmodifiableSet());
//
//        return new Test()
//                .setName(newTestRequest.getName())
//                .setDescription(newTestRequest.getDescription())
//                .setDuration(Duration.ofSeconds(newTestRequest.getDuration()))
//                .setInstructions(newTestRequest.getInstructions())
//                .setQuestions(questions)
//                .setStart(newTestRequest.getStart())
//                .setTimed(newTestRequest.isTimed());
//    }

    public static Test toTest(TestRequest newTestRequest){
        return new Test()
                .setName(newTestRequest.getName())
                .setDescription(newTestRequest.getDescription())
                .setDuration(Duration.ofSeconds(newTestRequest.getDuration()))
                .setInstructions(newTestRequest.getInstructions())
                .setStart(newTestRequest.getStart())
                .setTimed(newTestRequest.isTimed());
    }

    public static TestDto toDto(Test test){
        Set<QuestionDto> questions = test.getQuestions()
                .stream().map(QuestionMapper::toDto)
                .collect(Collectors.toUnmodifiableSet());

        return new TestDto()
                .setId(test.getId())
                .setCreated(test.getCreated())
                .setDescription(test.getDescription())
                .setName(test.getName())
                .setDuration(test.getDuration())
                .setStart(test.getStart())
                .setInstructions(test.getInstructions())
                .setQuestions(questions)
                .setTimed(test.isTimed());
    }
}
