package org.telusko;

import service.DevOps;
import service.Icourse;

public class Telusko {
    public Telusko(Icourse course) {
        super();
        this.course = course;
    }
    public Telusko() {
        super();

    }

    private Icourse course;

    public void setCourse(Icourse course) {
        this.course = course;
    }

     public boolean buyTheCourse(){
//        DevOps  d = new DevOps();
////        boolean stauts = d.registerCourse();
//        return d.registerCourse();
         return course.registerCourse();
    }
}
