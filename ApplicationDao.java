package com.jsp.ojpms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jsp.ojpms.entity.Application;
import com.jsp.ojpms.util.JPAUtil;

public class ApplicationDao {

	public static void saveApplication(Application application) {
		EntityManager em = JPAUtil.getEm();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(application);
		et.commit();
	}

	public static boolean isAlreadyApplied(int uId, int jobId) {
		EntityManager em = JPAUtil.getEm();
		Query query = em.createQuery("FROM Application WHERE user.id = ?1 AND job.id = ?2");
		query.setParameter(1, uId);
		query.setParameter(2, jobId);

		List list = query.getResultList();

		boolean empty = list.isEmpty();

		System.out.println("List is Empty : " + empty);

		return !empty;
	}

	public static List<Application> getApplicationsByUser(int userId) {
		EntityManager em = JPAUtil.getEm();

		Query query = em.createQuery("FROM Application WHERE user.id = ?1");

		query.setParameter(1, userId);

		return query.getResultList();
	}

	public static List<Application> getAllApplications() {
		EntityManager em = JPAUtil.getEm();

		Query query = em.createQuery("FROM Application");

		return query.getResultList();
	}

	public static int getApplicationCountByUser(int userId) {
		EntityManager em = JPAUtil.getEm();

		Query query = em.createQuery("SELECT COUNT(a) FROM Application a WHERE user.id=?1");

		query.setParameter(1, userId);

		Long count = (Long) query.getSingleResult();

		return count.intValue();
	}

	public static int getApplicationCountForRecruiter(int recruiterId) {
		EntityManager em = JPAUtil.getEm();

		Query query = em.createQuery("SELECT COUNT(a) FROM Application a WHERE a.job.recuriter.id=?1");

		query.setParameter(1, recruiterId);

		Long count = (Long) query.getSingleResult();

		return count.intValue();
	}

	public static Application getApplicationById(int id) {

		EntityManager em = JPAUtil.getEm();

		return em.find(Application.class, id);
	}

	public static void updateStatus(int applicationId, String status) {

		EntityManager em = JPAUtil.getEm();

		EntityTransaction et = em.getTransaction();

		Application application = em.find(Application.class, applicationId);

		if (application != null) {

			et.begin();
			application.setStatus(status);
			em.merge(application);
			et.commit();
		}
	}
}
