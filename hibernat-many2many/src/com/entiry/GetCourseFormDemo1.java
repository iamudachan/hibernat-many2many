package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseFormDemo1 {

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

			int id = 2;
			Student s1 = s.get(Student.class,1);
			System.out.println(s1);
			System.out.println(s1.getCourse());
		
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
 