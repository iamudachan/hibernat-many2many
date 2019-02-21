package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseFormDemo {

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
			
			
			Course course1 = new Course("java");
			Course course2 = new Course("game");
			course1.addStudent(s1);
			course2.addStudent(s1);
			
			s.save(course1);
			s.save(course2);
			System.out.println();
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
 