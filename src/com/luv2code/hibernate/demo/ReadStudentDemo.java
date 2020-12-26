package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			Student student = new Student("Anil", "Malla", "anil@gmail.com");

			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();

			// Retrieve data for given primary key
			
		   session = factory.getCurrentSession();

			session.beginTransaction();
			
			Student t = session.get(Student.class, student.getId());

			session.getTransaction().commit();
			
			System.out.println(t.toString());

		} finally {
			factory.close();
		}

	}

}
