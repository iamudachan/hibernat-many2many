package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			s.beginTransaction();

			int courseId = 2;
			Course course = s.get(Course.class , courseId);
			s.delete(course);
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
 