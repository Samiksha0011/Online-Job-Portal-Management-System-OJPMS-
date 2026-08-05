package com.jsp.ojpms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jsp.ojpms.entity.JobSeekerProfile;
import com.jsp.ojpms.util.JPAUtil;

public class JobSeekerProfileDao {

	public static void saveProfile(JobSeekerProfile profile) {
		EntityManager em = JPAUtil.getEm();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(profile);
		et.commit();
	}

	public static JobSeekerProfile getProfileByUserId(int userId) {
		try {
			EntityManager em = JPAUtil.getEm();

			Query query = em.createQuery("FROM JobSeekerProfile WHERE user.id=?1");

			query.setParameter(1, userId);

			return (JobSeekerProfile) query.getSingleResult();
		} catch (Exception e) {
			  e.printStackTrace();
			return null;
		}
	}

	public static void updateProfile(JobSeekerProfile profile) {
		EntityManager em = JPAUtil.getEm();

		EntityTransaction et = em.getTransaction();

		et.begin();

		em.merge(profile);

		et.commit();
	}
	
	public static JobSeekerProfile getProfileById(int id) {

		EntityManager em = JPAUtil.getEm();

		return em.find(JobSeekerProfile.class, id);
	}

}
