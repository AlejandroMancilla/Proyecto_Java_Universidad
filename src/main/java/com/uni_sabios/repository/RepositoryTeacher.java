package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Teacher;

public interface RepositoryTeacher {

    List<Person> list();

    Person getPerson(String document);

    void create(Teacher teacher);

    void create(Person person, int id_department) throws PersonExceptionInsertDataBase;

    void modify(Teacher teacher);

    void delete(String document);

}
