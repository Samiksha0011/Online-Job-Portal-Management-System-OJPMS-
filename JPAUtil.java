package com.jsp.ojpms.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//We are using Singleton design pattern to create object of EntityManager
public class JPAUtil {

	private static EntityManager em = null ;
	
	private JPAUtil() {
		
	}
	
	public static EntityManager getEm()
	{
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("jsp");

		return emf.createEntityManager();
	}
}
