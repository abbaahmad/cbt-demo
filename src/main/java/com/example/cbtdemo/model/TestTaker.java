package com.example.cbtdemo.model;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

public class TestTaker {
    @Id
    @SequenceGenerator(name = "test_taker_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_taker_sequence")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="test")
    @JoinColumn(name="test_id")
    private Set<Test> testsTaken;

    private Map<Test,Integer> answeredCorrectly;

    private Set<Question> answeredWrongly;

    //private Map<String,Double> testScore;

}
