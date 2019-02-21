package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

			int stdId = 1;
			Student student = s.get(Student.class , stdId);
			System.out.println(student);
			System.out.println(student.getCourse());
			s.delete(student);
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
		
		/*  output
		 * Hibernate: delete from nmc.course_student where student_id=?
			Hibernate: delete from nmc.student where id=?

		 */
	}
}
 