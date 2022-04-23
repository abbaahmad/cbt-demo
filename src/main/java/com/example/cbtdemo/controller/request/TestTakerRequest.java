package com.example.cbtdemo.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestTakerRequest {
    @NotBlank(message = "Please provide first name")
    private String first_name;

    @NotBlank(message = "Please provide last name")
    private String last_name;

    private Set<TestRequest> testsTaken;
}
