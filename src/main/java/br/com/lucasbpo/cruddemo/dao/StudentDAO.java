package br.com.lucasbpo.cruddemo.dao;

import br.com.lucasbpo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Long id);

    int deleteAll();
}
