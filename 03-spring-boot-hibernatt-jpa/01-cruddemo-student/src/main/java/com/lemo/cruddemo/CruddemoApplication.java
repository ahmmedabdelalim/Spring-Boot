package com.lemo.cruddemo;

import com.lemo.cruddemo.dao.StudentDAO;
import com.lemo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
//	inject Student DAO
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return  runner ->
		{
			createStudent(studentDAO);
			createMultiplestudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudent(studentDAO);
//			queryForStudentByLastname(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
		};

	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Delete all student");
		int numRowsDeletedstudent = studentDAO.deleteAll();
		System.out.println("deleteRows Count = "  + numRowsDeletedstudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentid = 3 ;
		System.out.println("Delete Student id  : " +studentid);

		studentDAO.delete(studentid);
	}

	private void updateStudent(StudentDAO studentDAO) {
//		select student based on id
		int studentId = 1;
		System.out.println("Getting student with id:" + studentId);
		Student mystudent = studentDAO.findById(studentId);

//		change first name to ..
		System.out.println("update student ");
		mystudent.setFirst_name("LEMO");

//		update
		studentDAO.update(mystudent);

// display after update
		System.out.println("update student " + mystudent);
	}

	private void queryForStudentByLastname(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findByLastName("ff");
		for ( Student student : students)
		{
			System.out.println(student);
		}	

	}

	private void queryForStudent(StudentDAO studentDAO) {
//		get list of student
		List<Student> students = studentDAO.findAll();
//		display student
		for ( Student student : students)
		{
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

//		create student object
		Student student1 = new Student("www" , "qwdqd" ,"qwwef");

//		save the student
		studentDAO.save(student1);

//		display id of saving student

		int theId = student1.getId();
//		retrive the student by id

		Student myStudent  = studentDAO.findById(theId);
		System.out.println(myStudent);
	}

	private  void createMultiplestudent(StudentDAO studentDAO)
	{
//			create multi student
		System.out.println("Creating new students object ...");
		Student tempStudent1 = new Student("ahmed", "mohamed" , "pppsa@.com");
		Student tempStudent2 = new Student("dd", "ff" , "FDSf@.com");
		Student tempStudent3 = new Student("ll", "rr" , "fdfgrg@.com");

//		saving multi student
		System.out.println("saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	private void createStudent(StudentDAO studentDAO) {
//		create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("ahmed", "mohamed" , "pppsa@.com");

//		save the student object
		System.out.println("saving the student ...");
		studentDAO.save(tempStudent);

//		display id for saved student

		System.out.println("Saving student. Generated id " + tempStudent.getId());
	}


}
