package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.classroomexceptions.ClassroomExceptionInsertDataBase;
import com.uni_sabios.exceptions.classroomexceptions.ClassroomNullException;
import com.uni_sabios.repository.models.Classroom;

public interface ServiceClassroom {
    
    List<Classroom> list();

    Classroom getClassroom(int classroomId) throws ClassroomNullException;

    void create(Classroom classroom) throws ClassroomExceptionInsertDataBase;

    void modify(Classroom classroom);

    void delete(Classroom classroom);

}
