package com.example.hospitalspring.repository;

import com.example.hospitalspring.model.Doctor;
import com.example.hospitalspring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();
    List<Patient> findAllByDoctor(Doctor doctor);

    Patient getByCnp(String cnp);
}
