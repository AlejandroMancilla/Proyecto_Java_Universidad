package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.exceptions.personexceptions.PersonNullException;
import com.uni_sabios.exceptions.studentexceptions.StudentNullException;
import com.uni_sabios.repository.RepositoryStudent;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Student;
import com.uni_sabios.services.ServiceStudent;



public class ServiceStudentImpl implements ServiceStudent{

    private final RepositoryStudent crudRepositoryStudent;

    public ServiceStudentImpl(RepositoryStudent crudRepositoryStudent) {
        this.crudRepositoryStudent = crudRepositoryStudent;
    }
    
    public List<Person> list(){
        return crudRepositoryStudent.toList();
    }
    
    public Person findByDocument(String document) throws PersonNullException {
        Person person = crudRepositoryStudent.findByDocument(document);
        if(person == null){
            throw new PersonNullException("Person not found");
        } else {
            return person;
        }
    }

    @Override
    public Student findbyId(int personId) throws StudentNullException {
        Student student = crudRepositoryStudent.findById(personId);
        if(student == null){
            throw new StudentNullException("Student not found");
        } else {
            return student;
        }
    }

    public int getId(String document) throws PersonNullException {
        Person person = crudRepositoryStudent.findByDocument(document);
        if(person == null){
            throw new PersonNullException("Person not found");
        } else {
            return person.getId();
        }

    }

    public void create(Student student) {
        crudRepositoryStudent.create(student);
    }

    public void create(Person person, int idProgram) throws PersonExceptionInsertDataBase{
        crudRepositoryStudent.create(person, idProgram);
    }

    public void update(Student student) {
        crudRepositoryStudent.modify(student);
    }

    public void delete(Student student) throws PersonNullException {
        crudRepositoryStudent.delete(student);
    }

    public void delete(String document) throws PersonNullException {
        crudRepositoryStudent.delete(document);
    }

    
}
 