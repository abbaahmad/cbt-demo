package com.example.cbtdemo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
public class TestTaker {
    @Id
    @SequenceGenerator(name = "test_taker_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_taker_sequence")
    private Long id;

    private String first_name;

    private String last_name;

    @ManyToMany
    @JoinTable(
            name="test",
            joinColumns = @JoinColumn(name="test_id")
    )
    private Set<Test> testsTaken;
}
