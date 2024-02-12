package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.classroomexceptions.ClassroomExceptionInsertDataBase;
import com.uni_sabios.exceptions.classroomexceptions.ClassroomNullException;
import com.uni_sabios.repository.RepositoryClassroom;
import com.uni_sabios.repository.models.Classroom;
import com.uni_sabios.services.ServiceClassroom;

public class ServiceClassroomImpl implements ServiceClassroom{
    
    private final RepositoryClassroom crudRepositoryClassroom;

    public ServiceClassroomImpl(RepositoryClassroom crudRepositoryClassroom) {
        this.crudRepositoryClassroom = crudRepositoryClassroom;
    }
    
    public List<Classroom> list() {
        return crudRepositoryClassroom.list();
    
    }

    public Classroom getClassroom(int classroomId) throws ClassroomNullException{
        return crudRepositoryClassroom.getClassroom(classroomId);
    }

    public void create(Classroom classroom) throws ClassroomExceptionInsertDataBase{
        this.crudRepositoryClassroom.create(classroom);
    }

    public void modify(Classroom classroom){
        this.crudRepositoryClassroom.modify(classroom);
    }

    public void delete(Classroom classroom){
        this.crudRepositoryClassroom.delete(classroom);
    }

    
}
