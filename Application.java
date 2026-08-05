package com.jsp.ojpms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Job job;

	@ManyToOne
	private User user;
	private String status="APPLIED";
	private LocalDate appliedDate;
	private String resumePath;
	
	public Application() {
		// TODO Auto-generated constructor stub
	}

	public Application(int id, Job job, User user, String status, LocalDate appliedDate) {
		super();
		this.id = id;
		this.job = job;
		this.user = user;
		this.status = status;
		this.appliedDate = appliedDate;
	}

	public Application(int id, Job job, User user, String status, LocalDate appliedDate, String resumePath) {
		super();
		this.id = id;
		this.job = job;
		this.user = user;
		this.status = status;
		this.appliedDate = appliedDate;
		this.resumePath = resumePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getResumePath() {
		return resumePath;
	}

	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", job=" + job + ", user=" + user + ", status=" + status + ", appliedDate="
				+ appliedDate + ", resumePath=" + resumePath + "]";
	}

	
	
	
	
}
