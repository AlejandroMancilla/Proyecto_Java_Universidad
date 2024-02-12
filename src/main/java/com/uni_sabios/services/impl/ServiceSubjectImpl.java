package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.subjectexceptions.SubjectNullException;
import com.uni_sabios.repository.RepositorySubject;
import com.uni_sabios.repository.models.Subject;
import com.uni_sabios.services.ServiceSubject;

public class ServiceSubjectImpl implements ServiceSubject{

    private final RepositorySubject crudRepositorySubject;

    public ServiceSubjectImpl(RepositorySubject crudRepositorySubject) {
        this.crudRepositorySubject = crudRepositorySubject;
    }

    @Override
    public List<Subject> list() {
        return this.crudRepositorySubject.list();
    }

    @Override
    public Subject getSubject(int subjectId) throws SubjectNullException {
        Subject subject = this.crudRepositorySubject.getSubject(subjectId);
        if(subject != null){
            return subject;
        }else{
            throw new SubjectNullException("No Subject with this Id was found");
        }
    }

    @Override
    public void create(Subject subject) {
        this.crudRepositorySubject.create(subject);
    }

    @Override
    public void modify(Subject subject) {
        this.crudRepositorySubject.modify(subject);
    }

    @Override
    public void delete(Subject subject) {
        this.crudRepositorySubject.delete(subject);
    }
    
}
