package org.telusko;

import service.DevOps;
import service.SystemDesign;

public class LaunchSpring {
    public static void main(String[] args) {
//        SystemDesign sd = new SystemDesign(); // Dependent object
        //Constructor Injection
        Telusko t = new Telusko(new DevOps());  //Target/Target Class
//        t.setCourse(new SystemDesign());    //setter injection
        boolean status = t.buyTheCourse();
        if (status){
            System.out.println("Sucessfully regeistered at Telusko");
        }else {
            System.out.println("Failed to registred");
        }

    }
}
