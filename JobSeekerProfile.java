package com.jsp.ojpms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class JobSeekerProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private User user;
	private String headline;

	@Column(length = 2000)
	private String about;
	private String mobileNumber;
	private String skills;
	private String education;
	private String college;
	private String graduationYear;
	private String location;
	private String linkedinUrl;
	private String githubUrl;
	private String resumePath;
	
	public JobSeekerProfile() {

	}

	public JobSeekerProfile(int id, User user, String headline, String about, String mobileNumber, String skills,
			String education, String college, String graduationYear, String location, String linkedinUrl,
			String githubUrl, String resumePath) {
		super();
		this.id = id;
		this.user = user;
		this.headline = headline;
		this.about = about;
		this.mobileNumber = mobileNumber;
		this.skills = skills;
		this.education = education;
		this.college = college;
		this.graduationYear = graduationYear;
		this.location = location;
		this.linkedinUrl = linkedinUrl;
		this.githubUrl = githubUrl;
		this.resumePath = resumePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getGithubUrl() {
		return githubUrl;
	}

	public void setGithubUrl(String githubUrl) {
		this.githubUrl = githubUrl;
	}

	public String getResumePath() {
		return resumePath;
	}

	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	
	
}
