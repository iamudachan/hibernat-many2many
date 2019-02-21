package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStrudenDemo {

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

			Course course = new Course("Hello to all111");
			
			 
			s.save(course);
			Student student = new Student("s1", "s1", "111");
			Student student1 = new Student("s2", "s2", "222");
			Student student2 = new Student("s3", "s3", "3333");
			course.addStudent(student);
			course.addStudent(student1);
			course.addStudent(student2);
			s.save(student);
			s.save(student1);
			s.save(student2);
			System.out.println(course.getStudent());
			
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
