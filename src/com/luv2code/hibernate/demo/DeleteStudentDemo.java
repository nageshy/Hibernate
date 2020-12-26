package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			String studentId = "6";

			session.beginTransaction();

			Student student = session.get(Student.class, studentId);

			session.delete(student);

			session.getTransaction().commit();

			// // using executeUpdate() to delete
			// session = factory.getCurrentSession();
			// session.beginTransaction();
			// session.createQuery("Delete from Student where
			// id='6'").executeUpdate();

			System.out.println(student.toString());

		} finally {
			factory.close();
		}

	}

}
