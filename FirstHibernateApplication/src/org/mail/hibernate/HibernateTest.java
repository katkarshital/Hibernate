package org.mail.hibernate;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mail.test.Address;
import org.mail.test.EmailAddress;
import org.mail.test.UserDetails;

public class HibernateTest {
	public static void main(String[] args) {
		UserDetails userObj = new UserDetails();
		
		//userObj.setUserId(11);
		EmailAddress emailId = new EmailAddress();
		emailId.setUserName("katkarcool");
		emailId.setDomainName("gmail.com");
		userObj.setEmailId(emailId);
		
		userObj.setUserName("User 11");
		userObj.setJoingDate(new Date());
		Address userAdd = new Address();
		userAdd.setStreet("Cronin terrace");
		userAdd.setCity("Fremont");
		userAdd.setState("CA");
		userAdd.setZipcode("94555");
		userObj.setDescription("User 11 details");
		userObj.setHomeAddress(userAdd);
		
		Address officeAdd = new Address();
		userAdd.setStreet("1122 N st Street");
		userAdd.setCity("San Jose");
		userAdd.setState("CA");
		userAdd.setZipcode("94346");
		userObj.setOfficeAddress(officeAdd);
		
		SessionFactory sessionFactoryObj = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactoryObj.openSession();
		
		session.beginTransaction();
		session.save(userObj);
		
		session.getTransaction().commit();
		session.close();
		
		userObj =null;
		session = sessionFactoryObj.openSession();
		userObj= (UserDetails)session.get(UserDetails.class, emailId);
		System.out.println("User Id "+userObj.getEmailId().getUserName()+"@"+userObj.getEmailId().getDomainName());
		System.out.println("User Name "+userObj.getUserName());
	}

}
