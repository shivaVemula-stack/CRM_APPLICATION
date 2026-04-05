package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;
import org.hibernate.query.Query;

import java.util.List;

public class GetRecordApp 
{

//    private static Object s;

    public static void main(String[] args) 
	{
			SessionFactory sessionFactory = new Configuration().configure()
					.addAnnotatedClass(Student.class).buildSessionFactory();
			Session session1 =null;
            Transaction transaction = null;
            boolean flag = false;
            int count =0;
//
			
			try
			{
			   session1 = sessionFactory.openSession();
               transaction = session1.beginTransaction();
//                 count = session1.createQuery("UPDATE Student SET name=: stuName where id=:stuId")
//                        .setParameter("stuName", "Rajneesh").setParameter("stuId", 3).executeUpdate();

                count = session1.createQuery("DELETE  FROM  Student  where id=:stuId")
                        .setParameter("stuId", 4).executeUpdate();
                    flag = true;
                //SELECT * FROM studentinfo;
//                Query<Student> query = session1.createQuery("FROM Student WHERE city=:stuCity",Student.class);
//                Query<String> query = session1.createQuery("SELECT name FROM Student WHERE city=:stuCity",String.class);
//                Query<String> query = session1.createQuery("SELECT name FROM Student WHERE city IN (:stuCity1,:stuCity2)",String.class);


//                query.setParameter("stuCity1","Bombay" );
//                query.setParameter("stuCity2","Delhi" );

//                List<Student> listStudent = query.list();
//                List<String> listStudent = query.list();

//                for (Student s: listStudent){
//                    System.out.println(s);
//                }
//                listStudent.forEach((s)-> System.out.println(s));

            }
			catch(HibernateException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
                if (flag == true){
                    transaction.commit();
                    System.out.println("No of rows deleted "+ count);
                }else {
                    transaction.rollback();
                    System.out.println("No of rows deleted "+ count);

                }
			    session1.close();
			    sessionFactory.close();
			}
		


	}

}
