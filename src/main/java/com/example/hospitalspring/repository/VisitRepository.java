package com.example.hospitalspring.repository;

import com.example.hospitalspring.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();
    List<Visit> findAllByPatientCnp(String cnp);
    List<Visit> findAllByPatientSpecialty(String specialty);
}
