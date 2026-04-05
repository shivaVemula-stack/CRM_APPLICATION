package com.telusko.service;

public class DevOps implements Icourse {
    public DevOps(){
        System.out.println("DevOps bean created");
    }
    @Override
    public boolean registerCourse(double amount) {
        System.out.println("Enrolled to DevOps for "+amount);
        return true;

    }
}
