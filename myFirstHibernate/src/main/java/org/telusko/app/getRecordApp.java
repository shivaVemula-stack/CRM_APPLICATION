package org.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.telusko.model.Student;



public class getRecordApp {
    public static void main(String[] args) {


        Session session = null;
//        Transaction transaction = null;
        boolean flag = false;


        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            session = sessionFactory.openSession();

//            Student student = session.get(Student.class, 1);  // Eager Loading


            Student student = session.load(Student.class, 1);      // Lazy Loading
//            System.out.println(student);
            System.out.println("Id is "+ student.getSid());
            System.out.println("Name is "+ student.getSname());
            System.out.println("City is "+ student.getScity());

            flag = true;

        }catch (HibernateException he){
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            session.close();
            sessionFactory.close();
        }



    }
}
