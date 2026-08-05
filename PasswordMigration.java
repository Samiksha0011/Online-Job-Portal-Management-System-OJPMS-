package com.jsp.ojpms.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jsp.ojpms.entity.User;

public class PasswordMigration {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEm();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("FROM User");

		List<User> users = query.getResultList();

		et.begin();

		for(User user : users)
		{
			String plainPassword = user.getPassword();

			String hashedPassword =
					PasswordUtil.hashPassword(
							plainPassword);

			user.setPassword(hashedPassword);

			em.merge(user);

			System.out.println(
					user.getEmail()
					+ " migrated successfully");
		}

		et.commit();

		System.out.println(
				"\nAll passwords migrated successfully...");
	}
}