package com.example.hospitalspring.service;

import com.example.hospitalspring.model.Doctor;
import com.example.hospitalspring.model.Patient;
import com.example.hospitalspring.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    final PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public void savePatient(Patient patient){
        patientRepository.save(patient);
    }

    public Patient getPatientById(Integer patientId){
        System.out.println(patientRepository.findById(patientId).get());
        return patientRepository.findById(patientId).get();
    }

    public List<Patient> getAllByDoctor(Doctor doctor){
        return patientRepository.findAllByDoctor(doctor);
    }

    public Patient getPatientByCnp(String cnp){
        return patientRepository.getByCnp(cnp);
    }
}
