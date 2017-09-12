package com.kodzilar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodzilar.entity.History;
import com.kodzilar.entity.Mission;

@Repository
public interface MissionRepository extends CrudRepository<Mission, Long> {
    public List<Mission> findByParkName(String parkName);
    public void save(History history);    
}