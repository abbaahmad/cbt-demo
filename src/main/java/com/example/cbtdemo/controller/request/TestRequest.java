package com.example.cbtdemo.controller.request;

import com.example.cbtdemo.util.CustomLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestRequest {
    @NotBlank(message = "Please provide name")
    private String name;

    @NotBlank(message = "Please provide exam description")
    private String description;

    @NotBlank(message = "Please provide exam instructions")
    private String instructions;

    @NotNull(message = "Please provide a date.")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime start;

    @Min(value = 300, message = "Duration can not be less than 5 minutes!")
    private int duration;

    private boolean isTimed;

    @Min(value=0, message="Cut off cannot be less than 0")
    @Max(value=100, message="Cut off cannot be more than 100")
    private Double cutOff; //TODO: Determine max score possible and substitute for '100'

    //@NotEmpty(message = "Please add candidates to take the test")
    private Set<TestTakerRequest> testTakers;

    private Set<QuestionRequest> questions;
}
