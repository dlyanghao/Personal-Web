package com.yanghao.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yanghao.pojo.User;

public class HibernateTest {
	
	
//ÃÌº””√ªß
@Test
public void addUser(){
	Configuration confuguration = new Configuration().configure();
	SessionFactory sessionFactory = confuguration.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction ts = session.beginTransaction();
	ts.begin();
	User user = new User();
	user.setAccount("admin");
	user.setPassword("123");
	session.persist(user);
	ts.commit();
	session.close();
}

}
