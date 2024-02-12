package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Teacher;

public interface RepositoryTeacher {

    List<Person> list();

    Person getPerson(String document);

    void create(Teacher teacher);

    void modify(Teacher teacher);

    void delete(Teacher teacher);
    
}
