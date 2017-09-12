package com.kodzilar.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodzilar.entity.Question;

@Transactional
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    public List<Question> findByMissionId(int missionId);
}