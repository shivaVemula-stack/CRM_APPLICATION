package org.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.telusko.model.Student;



public class LaunchDelete {
    public static void main(String[] args) {


        Session session = null;
        Transaction transaction = null;
        boolean flag = false;


        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();





        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Student student = new Student();
            student.setSid(3);
            student.setSname("Harsh");
            student.setScity("Kochi");

//            session.delete(student);
            session.remove(student);
            flag = true;

        }catch (HibernateException he){
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (flag == true){
                transaction.commit();
            }else {
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
        }



    }
}
