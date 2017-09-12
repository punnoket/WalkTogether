package com.kodzilar.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodzilar.entity.Question;

@Transactional
@Repository
public interface TestQuestionRepository extends CrudRepository<Question, Long> {

}