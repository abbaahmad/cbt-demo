package com.example.cbtdemo.repository;

import com.example.cbtdemo.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResponseRepository extends JpaRepository<Response, Long> {

    @Query("SELECT r FROM Response r WHERE r.test_taker_id = SELECT t.id FROM TestTaker t WHERE t.first_name = ?1 and t.last_name=?2")
    Response findByName(String first_name, String last_name);

    @Query("SELECT r FROM Response r WHERE r.test_taker_id = SELECT t.id FROM TestTaker t WHERE t.first_name = ?1")
    Response findByFirstName(String first_name);

    @Query("SELECT r FROM Response r WHERE r.test_taker_id = SELECT t.id FROM TestTaker t WHERE t.last_name = ?1")
    Response findByLastName(String last_name);

    @Query("SELECT r FROM Response r WHERE r.question_id = SELECT q.id FROM Question q WHERE q.number = ?1")
    Response findByQuestionNumber(int number);

    @Query("SELECT r FROM Response r WHERE r.test_id = SELECT t.id FROM Test t WHERE t.name = ?1")
    Response findByTestName(String name);
}
