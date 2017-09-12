package com.kodzilar.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodzilar.entity.History;
import com.kodzilar.entity.Mission;
import com.kodzilar.entity.Caretaker;
import com.kodzilar.entity.Patient;
import com.kodzilar.entity.Question;
import com.kodzilar.repository.HistoryRepository;
import com.kodzilar.repository.MissionRepository;
import com.kodzilar.repository.PatientRepository;
import com.kodzilar.repository.QuestionRepository;
import com.kodzilar.repository.CaretakerRepository;

import javax.persistence.*;

@Service
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private CaretakerRepository caretakerRepository;

    public List<Mission> getMissionByParkName(String parkName) {
        List<Mission> missions = missionRepository.findByParkName(parkName);

        for(Mission mission: missions){
            List<Question> questions = questionRepository.findByMissionId(mission.getMissionId());
            mission.setQusetions(questions);
        }

        return missions;
    }

    public void save(History history){
        Patient patient = patientRepository.findByUsername(history.getPatientName());
        history.setPatientId(patient.getPatientId());
        missionRepository.save(history);
    }

    public List<History> getHistoryById(History history){
        Patient patient = patientRepository.findByUsername(history.getPatientName());
        return historyRepository.findAllByPatientIdOrderByLastMntDateAsc(patient.getPatientId(), history.getLastMntDate());
    }

    public List<History> getDateListById(History history){
        Patient patient = patientRepository.findByUsername(history.getPatientName());
        return historyRepository.findDateByIdOrderByDateAsc(patient.getPatientId());
    }

    public List<String> getPatientListByCaretakerId(String emailCaretaker){
        Caretaker caretaker = new Caretaker();
        List<String> patient = new ArrayList<String>();
        caretaker = caretakerRepository.findByEmail(emailCaretaker);
        patient = historyRepository.findByCaretakerId(caretaker.getCartakerId());

        return patient;
    }

    public History getCheckHistoryByHistoryId(int historyId){
        return historyRepository.findAllByHistoryId(historyId);
    }

    public void saveHistory(History history){
        missionRepository.save(history);
    }
}
