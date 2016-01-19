package org.mail.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mail.test.Address;
import org.mail.test.UserDetails;

public class HibernateTest {
	public static void main(String[] args) {
		UserDetails userObj = new UserDetails();
		
		//userObj.setUserId(11);
		userObj.setUserName("User 11");
		userObj.setJoingDate(new Date());
		Address userAdd = new Address();
		userAdd.setStreet("Cronin terrace");
		userAdd.setCity("Fremont");
		userAdd.setState("CA");
		userAdd.setZipcode("94555");
		userObj.setDescription("User 11 details");
		userObj.setAddress(userAdd);
		
		
		SessionFactory sessionFactoryObj = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactoryObj.openSession();
		
		session.beginTransaction();
		session.save(userObj);
		
		session.getTransaction().commit();
		session.close();
		
		userObj =null;
		session = sessionFactoryObj.openSession();
		userObj= (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User Id "+userObj.getUserId());
		System.out.println("User Name "+userObj.getUserName());
	}

}
