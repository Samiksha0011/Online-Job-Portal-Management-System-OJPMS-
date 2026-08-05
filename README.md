

# Online Job Portal Management System (OJPMS)

## 📌 Project Overview

The **Online Job Portal Management System (OJPMS)** is a Java-based web application developed to streamline the recruitment process by connecting employers and job seekers on a single platform. The application enables employers to post job vacancies, job seekers to search and apply for jobs, and administrators to efficiently manage users and job listings.

---

## ✨ Features

### 👨‍💼 Admin

* Secure admin login
* Manage employers and job seekers
* Manage job categories
* View and manage job postings
* Monitor system activities

### 🏢 Employer

* Register and login
* Create, update, and delete job postings
* View job applicants
* Manage company profile

### 👤 Job Seeker

* Register and login
* Update personal profile
* Search jobs by category
* Apply for jobs
* View application status

---

## 🛠️ Technologies Used

* Java
* Servlets
* JSP (JavaServer Pages)
* Hibernate ORM
* JPA (Java Persistence API)
* PostgreSQL
* pgAdmin 4
* HTML5
* CSS3
* Bootstrap
* JavaScript
* Apache Tomcat
* Maven
* Git & GitHub

---

## 🗄️ Database

* **Database:** PostgreSQL
* **Database Management Tool:** pgAdmin 4

Update the database connection details in your Hibernate/JPA configuration file (such as `hibernate.cfg.xml` or `persistence.xml`) before running the application.

Example:

```properties
Database Name : ojpms
Username      : your_username
Password      : your_password
Port          : 5432
```

---

## 🚀 How to Run the Project

1. Clone this repository.
2. Import the project into Eclipse or Spring Tool Suite (STS).
3. Create the PostgreSQL database (`ojpms`) using pgAdmin 4.
4. Configure the database connection in the Hibernate/JPA configuration file.
5. Update Maven dependencies (if required).
6. Deploy the project on Apache Tomcat Server.
7. Start the Tomcat server.
8. Open your browser and navigate to:

```text
http://localhost:8080/ojpms
```

---

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/
│   ├── resources/
│   └── webapp/
│       ├── WEB-INF/
│       ├── css/
│       ├── js/
│       └── jsp/
```

---

## 🎯 Future Enhancements

AI-based job recommendations
Real-time chat between employers and job seekers
Interview scheduling with calendar integration
Two-factor authentication (2FA)
Mobile-responsive UI improvements

---

## 👩‍💻 Developed By

**Samiksha Patil**



---

## 📄 License

This project is intended for educational and learning purposes only.
