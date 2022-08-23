package com.example.hospitalspring.controller;

import com.example.hospitalspring.model.Doctor;
import com.example.hospitalspring.model.Patient;
import com.example.hospitalspring.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("patients")
public class PatientController {
    final PatientService patientService;

    @GetMapping("all")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
    @PostMapping("save")
    public void savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
    }
    @GetMapping("id/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        return patientService.getPatientById(id);
    }
    @GetMapping("doctor")
    public List<Patient> getAllPatientsByDoctor(@RequestBody Doctor doctor){
        return patientService.getAllByDoctor(doctor);
    }
    @GetMapping("cnp/{cnp}")
    public Patient getPatientByCnp(@PathVariable String cnp){
        return patientService.getPatientByCnp(cnp);
    }

}
