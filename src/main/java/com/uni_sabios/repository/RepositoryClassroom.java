package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.exceptions.classroomexceptions.ClassroomExceptionInsertDataBase;
import com.uni_sabios.repository.models.Classroom;

public interface RepositoryClassroom {

    List<Classroom> list();

    Classroom getClassroom(int classroomId);

    void create(Classroom classroom) throws ClassroomExceptionInsertDataBase;

    void modify(Classroom classroom);

    void delete(Classroom classroom);
}
