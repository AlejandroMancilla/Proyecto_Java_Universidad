package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Subject;

public interface RepositorySubject {

    List<Subject> list();

    Subject getSubject(int subjectId);

    void create(Subject subject);

    void modify(Subject subject);

    void delete(Subject subject);
    
}
