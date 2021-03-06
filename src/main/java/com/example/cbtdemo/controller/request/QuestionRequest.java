package com.example.cbtdemo.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionRequest {

    @NotNull
    private int number;

    @NotBlank(message = "Question cannot be empty!")
    private String text;

    private Set<String> options;

    private String answer;
}
