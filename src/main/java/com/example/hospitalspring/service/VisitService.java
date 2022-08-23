package com.example.hospitalspring.service;

import com.example.hospitalspring.model.Visit;
import com.example.hospitalspring.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    final VisitRepository visitRepository;

    public List<Visit> getAllVisits(){
        return visitRepository.findAll();
    }

    public void saveVisit(Visit visit){
        visitRepository.save(visit);
    }

    public List<Visit> getVisitsByCnp(String cnp){
        return visitRepository.findAllByPatientCnp(cnp);
    }
    public List<Visit> getVisitsBySpecialty(String specialty){
        return visitRepository.findAllByPatientSpecialty(specialty);
    }


}
