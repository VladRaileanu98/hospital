package com.example.hospitalspring.controller;

import com.example.hospitalspring.exceptions.NoDoctorException;
import com.example.hospitalspring.exceptions.NoSpecialtyException;
import com.example.hospitalspring.model.Doctor;
import com.example.hospitalspring.model.Specialty;
import com.example.hospitalspring.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping("save")
    public void saveDoctorC(@RequestBody Doctor doctor){
       doctorService.saveDoctorS(doctor);
    }

    @PostMapping("addpatient/{doctorId}/{patientId}")
    public void addPatient(@PathVariable Integer doctorId, @PathVariable Integer patientId){
        try{
            doctorService.addPatient(doctorId,patientId);
        }catch(NoDoctorException e){
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("all/{specialty}")
    public List<Doctor> getAllBySpecialty(@PathVariable Specialty specialty) throws NoSpecialtyException {
        try{
            return doctorService.getAllBySpecialty(specialty);
        }catch(MethodArgumentTypeMismatchException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Integer id){
        doctorService.deleteById(id);
    }
}
