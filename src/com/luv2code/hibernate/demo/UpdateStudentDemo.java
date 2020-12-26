package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			String studentId = "6";

			session.beginTransaction();

			Student student = session.get(Student.class, studentId);

			student.setFirstName("Sunil");

			student.setLastName("Arevati");

			student.setEmail("sunil@gmail.com");

			session.getTransaction().commit();

			// using executeUpdate()
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update from Student set email='foo@gmail.com' where id='6'").executeUpdate();

			session.getTransaction().commit();

			System.out.println(student.toString());

		} finally {
			factory.close();
		}

	}

}
