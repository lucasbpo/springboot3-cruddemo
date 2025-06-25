package br.com.lucasbpo.cruddemo.dao;

import br.com.lucasbpo.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Long id);
}
