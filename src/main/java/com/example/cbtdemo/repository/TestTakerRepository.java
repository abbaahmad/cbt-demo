package com.example.cbtdemo.repository;

import com.example.cbtdemo.model.TestTaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestTakerRepository extends JpaRepository<TestTaker, Long> {
}
