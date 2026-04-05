package com.telusko.main;


import com.telusko.service.Icourse;

public class Telusko {
    public Telusko(Icourse course) {
        super();
        this.course = course;
    }
    public Telusko() {
        super();
        System.out.println("Telusko bean is created");

    }



    private Icourse course;

    public void setCourse(Icourse course) {
        this.course = course;
    }

     public boolean buyTheCourse(double amount){
//        DevOps  d = new DevOps();
////        boolean stauts = d.registerCourse();
//        return d.registerCourse();
         return course.registerCourse(amount);
    }
}
