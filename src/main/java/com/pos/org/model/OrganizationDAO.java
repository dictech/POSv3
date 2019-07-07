package com.pos.org.model;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;


import com.pos.org.model.Organization;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrganizationDAO {
	
	static Boolean isOperationSuccessful = true;
	
	public static Boolean create(Organization org) {
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Organization.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.save(org);
			session.getTransaction().commit();
		}catch(HibernateException he) {
			he.printStackTrace();
			isOperationSuccessful = false;
		}
		finally {
			sessionFactory.close();
		}
		
		return isOperationSuccessful;
	}
	
	public static Organization viewOrganization(BigDecimal id) {
		Organization org = null;
		
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Organization.class)
				.buildSessionFactory();

        Session session = sessionFactory.openSession();
		
        try {
			session.beginTransaction();
			org = session.get(Organization.class, id);
			session.close();
        }finally {
			sessionFactory.close();
		}
        
        return org;
	}
	
	
	
	public static List<Organization> viewAllOrganization(){
		List<Organization> listOfOrgs =  new ArrayList<Organization>();
		
		Session session = new Configuration().configure("hibernate.cfg.xml")
											 .addAnnotatedClass(Organization.class)
											 .buildSessionFactory()
											 .openSession();
		
		session.beginTransaction();
		listOfOrgs = session.createQuery("from Organization",Organization.class).getResultList();
		session.getTransaction().commit();
		session.close();
		
		return listOfOrgs;
	}
	
	public static boolean updateOrganization(Organization org) {
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Organization.class)
				.buildSessionFactory();
        
		try {
			
			    Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.update(org);
				session.getTransaction().commit();
				session.close();
				
		}catch(HibernateException he) {
			he.printStackTrace();
			isOperationSuccessful =  false;
		}finally {
			sessionFactory.close();
		}
		
		return isOperationSuccessful;
       
	}
	

	public static boolean deleteOrganization(BigDecimal orgId) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Organization.class)
				.buildSessionFactory();
        
		try {
			
			    Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.createQuery("delete from Organization where org_id =" + orgId).executeUpdate();
				session.getTransaction().commit();
				session.close();
				
		}catch(HibernateException he) {
			he.printStackTrace();
			isOperationSuccessful =  false;
		}finally {
			sessionFactory.close();
		}
		
		return isOperationSuccessful;
	}
	
	
}
