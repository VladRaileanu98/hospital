package com.example.hospitalspring.service;

import com.example.hospitalspring.exceptions.NoDoctorException;
import com.example.hospitalspring.exceptions.NoSpecialtyException;
import com.example.hospitalspring.model.Doctor;
import com.example.hospitalspring.model.Patient;
import com.example.hospitalspring.model.Specialty;
import com.example.hospitalspring.repository.DoctorRepository;
import com.example.hospitalspring.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    final DoctorRepository doctorRepository;
    final PatientRepository patientRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public void saveDoctorS(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void addPatient(Integer doctorId, Integer patientId) throws NoDoctorException {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Patient> patient = patientRepository.findById(patientId);
        if(!doctor.isPresent()){
            throw new NoDoctorException();
        }
        else{
            if(patient.isPresent()){
                doctor.get().addPatient(patient.get());
                doctorRepository.save(doctor.get());

                patient.get().setDoctor(doctor.get());
                patient.get().setDoctorName();
                patientRepository.save(patient.get());

                System.out.println("All good. Added patient: "+patient+ "\nTo doctor: "+doctor);
            }
        }
    }

    public List<Doctor> getAllBySpecialty(Specialty specialty) throws NoSpecialtyException {
        if(!doctorRepository.findAllBySpecialty(specialty).isEmpty()){
            return doctorRepository.findAllBySpecialty(specialty);
        }else{
            throw new NoSpecialtyException();
        }
    }

    public void deleteById(Integer id){
        doctorRepository.deleteById(id);
    }
}
