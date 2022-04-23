package com.example.cbtdemo.dto.mapper;

import com.example.cbtdemo.controller.request.QuestionRequest;
import com.example.cbtdemo.dto.QuestionDto;
import com.example.cbtdemo.model.Question;

public class QuestionMapper {
    public static Question toQuestion(QuestionRequest questionRequest){
        return new Question()
                .setNumber(questionRequest.getNumber())
                .setOptions(questionRequest.getOptions())
                .setText(questionRequest.getText())
                .setAnswer(questionRequest.getAnswer());
    }

    public static QuestionDto toDto(Question question){
        return new QuestionDto()
                .setId(question.getId())
                .setNumber(question.getNumber())
                .setAnswer(question.getAnswer())
                .setText(question.getText())
                .setOptions(question.getOptions());
    }
}
