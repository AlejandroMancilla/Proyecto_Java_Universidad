package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.studentexceptions.StudentNotFoundException;
import com.uni_sabios.repository.models.Student;

public interface ServiceStudent {
    List<Student> list();

    Student getStudent(String id) throws StudentNotFoundException;

    void create(Student Student);

    void modify(Student Student);

    void delete(Student Student);
}
