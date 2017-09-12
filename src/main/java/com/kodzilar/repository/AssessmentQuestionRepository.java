package com.kodzilar.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodzilar.entity.AssessmentQuestion;

@Transactional
@Repository
public interface AssessmentQuestionRepository extends CrudRepository<AssessmentQuestion, Long> {

}