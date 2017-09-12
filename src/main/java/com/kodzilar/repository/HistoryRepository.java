package com.kodzilar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kodzilar.entity.History;
import com.kodzilar.entity.Patient;

import java.sql.Date;
import java.util.List;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {

    @Query("select h from History h where h.patientId = :id and date(h.lastMntDate) = :date")
    public List<History> findAllByPatientIdOrderByLastMntDateAsc(@Param("id") int patientId,@Param("date") Date date);

    @Query("select distinct date(h.lastMntDate) from History h where h.patientId = :id")
    public List<History> findDateByIdOrderByDateAsc(@Param("id") int patientId);

//หาในส่วนชื่อของผู้ป่วย
    @Query("select distinct p.name from Patient p where p.caretakerId = :id")
    public List<String> findByCaretakerId(@Param("id") int caretakerId);

//เลือกภารกิจ
    @Query("select h from History h where h.historyId = :id")
    public History findAllByHistoryId(@Param("id") int historyId);
}
