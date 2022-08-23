package com.example.hospitalspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String name;
    @NotNull
    String cnp;
    @OneToMany
    List<Visit> visitList = new ArrayList<>();

    @ManyToOne //many patients to a doctor
    @JsonBackReference
    Doctor doctor;
    String doctorName;

    public void setDoctorName(){
        this.doctorName = this.doctor.getName();
    }
}
