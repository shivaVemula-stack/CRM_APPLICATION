package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.AnswerTable;
import com.telusko.model.QuestionTable;

import java.util.ArrayList;
import java.util.List;

public class LaunchStandardApp 
{

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		QuestionTable q1=new QuestionTable();
		q1.setId(1);
		q1.setQuestion("What is Hibernate?");
		
		AnswerTable answer1 =new AnswerTable();
		answer1.setId(1);
		answer1.setAnswer("Hibernate is an ORM Framewok");

        AnswerTable answer2 =new AnswerTable();
        answer2.setId(2);
        answer2.setAnswer("Hibernate is an implementation of JPA");

        List<AnswerTable> answers = new ArrayList<AnswerTable>();
        answers.add(answer1);
        answers.add(answer2);

        q1.setAnswerList(answers);
		try
		{
			transaction=session.beginTransaction();
			//session.save(student);
			session.persist(q1);
//			session.persist(q2);
			
//			session.persist(answer1);
//			session.persist(answer2);
		   flag=true;
			
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
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
			
		}

	}

}
