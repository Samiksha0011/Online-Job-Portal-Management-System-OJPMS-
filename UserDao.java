package com.jsp.ojpms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.JPAUtil;
import com.jsp.ojpms.util.PasswordUtil;

public class UserDao {

	public static void save(User user) {
		EntityManager em = JPAUtil.getEm();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(user);
		et.commit();
//		em.close(); //It will help us to close EntityManager
	}

	public static User getUser(String email) {
		try {
			EntityManager em = JPAUtil.getEm();
			em.clear();

			Query query = em.createQuery("FROM User WHERE email = ?1");

			query.setParameter(1, email);

			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean updatePassword(String email, String password) {
		EntityManager em = JPAUtil.getEm();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Query query = em.createQuery("UPDATE User SET password = ?1 WHERE email = ?2");
		query.setParameter(1, password);
		query.setParameter(2, email);
		int update = query.executeUpdate();
		et.commit();
		em.clear();

		return update > 0;

	}

	public static void updateProfile(User user) {
		EntityManager em = JPAUtil.getEm();
		EntityTransaction et = em.getTransaction();

		User dbUser = em.find(User.class, user.getId());

		dbUser.setName(user.getName());

		et.begin();
		em.merge(dbUser);
		et.commit();

	}

	public static User getUserByEmail(String email) {
		try {
			EntityManager em = JPAUtil.getEm();

			Query query = em.createQuery("FROM User WHERE email = ?1");

			query.setParameter(1, email);

			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public static List<User> getAllJobSeekers() {
		EntityManager em = JPAUtil.getEm();

		Query query = em.createQuery("FROM User WHERE role='JOB_SEEKER'");

		return query.getResultList();
	}

	public static boolean updateEmail(int userId, String newEmail) {
		EntityManager em = JPAUtil.getEm();
		EntityTransaction et = em.getTransaction();

		User user = em.find(User.class, userId);

		if (user == null) {
			return false;
		}

		et.begin();
		user.setEmail(newEmail);
		em.merge(user);
		et.commit();
		em.clear();

		return true;
	}
}
