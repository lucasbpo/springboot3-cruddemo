package br.com.lucasbpo.cruddemo.dao;

import br.com.lucasbpo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();
}
