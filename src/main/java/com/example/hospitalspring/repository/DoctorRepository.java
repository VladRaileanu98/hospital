package com.example.hospitalspring.repository;

import com.example.hospitalspring.model.Doctor;
import com.example.hospitalspring.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();
    Doctor getById(Integer id);
    List<Doctor> findAllBySpecialty(Specialty specialty);
}
