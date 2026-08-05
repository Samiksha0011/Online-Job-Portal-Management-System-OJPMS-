package com.jsp.ojpms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.util.JPAUtil;

public class JobDao {

	public static void saveJob(Job job) {
		EntityManager em = JPAUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(job);
		et.commit();
	}

	public static List<Job> getAllJobs() {
		EntityManager em = JPAUtil.getEm();
		Query query = em.createQuery("FROM Job");
		List<Job> list = query.getResultList();
		return list;
	}

	public static List<Job> getSearchedJob(String search) {
		EntityManager em = JPAUtil.getEm();
		Query query = em.createQuery(
			    "FROM Job j WHERE " +
			    "LOWER(j.title) LIKE LOWER(?1) OR " +
			    "LOWER(j.description) LIKE LOWER(?1) OR " +
			    "LOWER(j.location) LIKE LOWER(?1) OR " +
			    "STR(j.salary) LIKE ?1"
			);
		query.setParameter(1, "%" + search + "%");
		List list = query.getResultList();

		return list;
	}

	public static List<Job> getJobsByRecruiter(int recruiterId) {
		EntityManager em = JPAUtil.getEm();

		Query query = em.createQuery("FROM Job WHERE recuriter.id = ?1");

		query.setParameter(1, recruiterId);

		return query.getResultList();
	}

	public static Job getJobById(int id) {
		EntityManager em = JPAUtil.getEm();

		return em.find(Job.class, id);
	}

	public static void updateJob(Job job) {
		EntityManager em = JPAUtil.getEm();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(job);
		et.commit();
	}

	public static int getJobCountByRecruiter(int recruiterId) {
		EntityManager em = JPAUtil.getEm();

		Query query = em.createQuery("SELECT COUNT(j) FROM Job j WHERE recuriter.id=?1");

		query.setParameter(1, recruiterId);

		Long count = (Long) query.getSingleResult();

		return count.intValue();
	}
	
	public static void removeJob(int id)
	{
	    EntityManager em = JPAUtil.getEm();
	    EntityTransaction et = em.getTransaction();

	    et.begin();

	    Query query = em.createQuery("DELETE FROM Application a WHERE a.job.id = ?1");

	    query.setParameter(1, id);
	    query.executeUpdate();

	    Job job = em.find(Job.class, id);

	    em.remove(job);

	    et.commit();
	}
}
