package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			s.beginTransaction();

			Course course = new Course("Hello to all111");
			course.addReview(new Review("Hello comment1"));
			course.addReview(new Review("Hello commen2t"));
			course.addReview(new Review("Hello comment3"));
			course.addReview(new Review("Hello comment4"));
			course.addReview(new Review("Hello comment5"));
			System.out.println(course);
			System.out.println(course.getReview());
			s.save(course);
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
