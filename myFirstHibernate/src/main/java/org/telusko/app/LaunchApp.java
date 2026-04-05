package org.telusko.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.telusko.model.Student;

import org.hibernate.cfg.Configuration;

public class LaunchApp {
    public static void main(String[] args) {
        //Step 1 configuraion object
        Configuration config = new Configuration();

        //Step 2 configure hibernate.cfg.xml file to the Configuration Object
        config.configure();

        // Step 3 Create Session Factory Object
        SessionFactory sessionFactory = config.buildSessionFactory();

        //Step 4 Get the session Object from session Factory
        Session session=  sessionFactory.openSession();

        //Step 5 Begin the Transaction within Session
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setSid(1);
        student.setSname("Remo");
        student.setScity("Chennai");

        //Step 6 perform Operation
        session.save(student);

        //Step 7 Performing Transaction Operations
        transaction.commit();
        //Step 8 close the session
        session.close();


    }
}


