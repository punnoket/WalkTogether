package com.kodzilar.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodzilar.entity.AssessmentScore;

@Transactional
@Repository
public interface AssessmentScoreRepository extends CrudRepository<AssessmentScore, Long> {

    public AssessmentScore findByPatientId(int id);
}