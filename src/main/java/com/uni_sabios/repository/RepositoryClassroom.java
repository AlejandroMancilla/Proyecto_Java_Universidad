package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Classroom;

public interface RepositoryClassroom {

    List<Classroom> list();

    Classroom getClassroom(String Code);

    void create(Classroom Classroom);

    void edit(Classroom Classroom);

    void delete(Classroom Classroom);
}
