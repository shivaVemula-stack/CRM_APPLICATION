package com.telusko.service;

public class SystemDesign implements Icourse {

    public SystemDesign(){
        System.out.println("System Design bean is created");
    }
    @Override
    public boolean registerCourse(double amount) {
        System.out.println("Enrolled to SystemDesingn Course for "+ amount);
        return true;

    }
}
