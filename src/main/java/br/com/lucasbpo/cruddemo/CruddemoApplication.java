package br.com.lucasbpo.cruddemo;

import br.com.lucasbpo.cruddemo.dao.StudentDAO;
import br.com.lucasbpo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			queryStudents(studentDAO);
//			queryStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students...");
		var rowsAffected = studentDAO.deleteAll();

		System.out.printf("Deleted row count %d%n", rowsAffected);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		var studentId = 3L;
		System.out.printf("Deleting student %d%n", studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		Long studentId = 1L;
		var student = studentDAO.findById(studentId);

		student.setFirstName("Scooby");
		studentDAO.update(student);

		System.out.printf("Updated student: %s%n", student);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {

		var students = studentDAO.findByLastName("Doe");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {

		var students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object ...");
		var student = new Student("John", "Doe", "john@example.com");

		System.out.println("Saving the student ...");
		studentDAO.save(student);

		Long id = student.getId();
		var savedStudent = studentDAO.findById(id);

		System.out.println(savedStudent);
	}


	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object ...");
		var student = new Student("Lucas", "Bispo", "lucas@example.com");

		System.out.println("Saving the student ...");
		studentDAO.save(student);

		System.out.printf("Saved student. Generated id %d%n", student.getId());
	}
}
