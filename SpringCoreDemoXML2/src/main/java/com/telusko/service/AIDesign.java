package com.telusko.service;

public class AIDesign implements Icourse {
    public AIDesign(){
        System.out.println("AI Design bean created");
    }
    @Override
    public boolean registerCourse(double amount) {
        System.out.println("Enrolled to AI Design Course for "+ amount);
        return true;

    }
}
