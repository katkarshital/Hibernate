package org.mail.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mail.test.Address;
import org.mail.test.UserDetailsWithArrayList;

public class HibernateTest {
	public static void main(String[] args) {
		UserDetailsWithArrayList userObj = new UserDetailsWithArrayList();
		
		userObj.setUserId(11);
		userObj.setUserName("User 11");
		
		Address userAdd1 = new Address();
		userAdd1.setStreet("Cronin terrace");
		userAdd1.setCity("Fremont");
		userAdd1.setState("CA");
		userAdd1.setZipcode("94555");
		
		Address userAdd2 = new Address();
		userAdd2.setStreet("Cronin terrace22");
		userAdd2.setCity("Fremont22");
		userAdd2.setState("CA22");
		userAdd2.setZipcode("9455522");
		
		Address userAdd3 = new Address();
		userAdd3.setStreet("Cronin terrace33");
		userAdd3.setCity("Fremont33");
		userAdd3.setState("CA33");
		userAdd3.setZipcode("9455533");
		
		userObj.getListOfAddresses().add(userAdd1);
		userObj.getListOfAddresses().add(userAdd2);
		userObj.getListOfAddresses().add(userAdd3);
		
		SessionFactory sessionFactoryObj = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactoryObj.openSession();
		
		session.beginTransaction();
		session.save(userObj);
		
		session.getTransaction().commit();
		session.close();
		
		userObj=null;
		session = sessionFactoryObj.openSession();
		userObj = (UserDetailsWithArrayList) session.get(UserDetailsWithArrayList.class, 1);
		session.close();
		System.out.println(userObj.getListOfAddresses().size());
		
	}

}
