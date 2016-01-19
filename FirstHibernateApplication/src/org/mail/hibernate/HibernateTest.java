package org.mail.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mail.test.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails userObj = new UserDetails();
		userObj.setUserId(1);
		userObj.setUserName("User 1");
		userObj.setJoingDate(new Date());
		userObj.setAddress("User 1 Address");
		userObj.setDescription("User 1 details");
		
		SessionFactory sessionFactoryObj = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactoryObj.openSession();
		
		session.beginTransaction();
		session.save(userObj);
		session.getTransaction().commit();
	}

}
