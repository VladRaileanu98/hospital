package com.example.hospitalspring.exceptions;

public class NoDoctorException extends Exception{
    //practic faci doar constructorul exceptiei
    public NoDoctorException(){
        super("this doctor does not exist!");
    }
}
