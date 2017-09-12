package com.kodzilar.repository;

import java.util.List;

import com.kodzilar.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    public Patient findByUsername(String username);

    public Patient findByEmailCaretaker(String email);

    public Patient findPatientByCaretakerId(int caretakerId);

    public List<Patient> findByCaretakerId(int caretakerId);
    
    public String findPatientIdByUsername(String username);
}
