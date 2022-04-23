package com.example.cbtdemo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
public class Question {
    @Id
    @SequenceGenerator(name = "question_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
    private Long id;

    private int number;

    private String text;

    @ElementCollection
    private Set<String> options;

    private String answer;

    private QuestionType questionType;

    private Double scorePoint;
}
