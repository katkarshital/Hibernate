package com.my.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.my.data.Student;

public class StudentClient {
	public static void main(String[] args){
		Student studObj = new Student();
		studObj.setStudId(121);
		studObj.setSubject("Math");
		studObj.setMarks(99);
		
		SessionFactory sessionFact = new Configuration().configure().buildSessionFactory();;
		Session session = sessionFact.openSession();
		
		session.beginTransaction();
		session.save(studObj);
		session.getTransaction().commit();
		
		session.close();
	}

}
