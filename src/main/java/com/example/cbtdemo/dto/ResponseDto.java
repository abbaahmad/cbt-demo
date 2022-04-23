package com.example.cbtdemo.dto;

import com.example.cbtdemo.model.TestTaker;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    private Long id;
    private TestDto testDto;
    private QuestionDto questionDto;
    private TestTakerDto testTakerDto;
    private String response;
}
