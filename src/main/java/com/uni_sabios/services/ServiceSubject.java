package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.subjectexceptions.SubjectNullException;
import com.uni_sabios.repository.models.Subject;

public interface ServiceSubject {
    List<Subject> list();

    Subject getSubject(int subjectId) throws SubjectNullException;

    void create(Subject subject);

    void modify(Subject subject);

    void delete(Subject subject);
}
