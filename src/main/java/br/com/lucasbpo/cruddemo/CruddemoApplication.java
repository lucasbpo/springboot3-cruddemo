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
			readStudent(studentDAO);
		};
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
