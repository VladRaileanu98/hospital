package com.example.hospitalspring.exceptions;

public class NoSpecialtyException extends Exception{
    public NoSpecialtyException(){
        super("this specialty does not exist!");
    }
}
