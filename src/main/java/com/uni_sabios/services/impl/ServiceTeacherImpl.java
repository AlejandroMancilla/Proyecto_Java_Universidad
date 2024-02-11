package com.uni_sabios.services.impl;

import com.uni_sabios.repository.RepositoryTeacher;
import com.uni_sabios.services.ServiceTeacher;

public class ServiceTeacherImpl implements ServiceTeacher{

    private final RepositoryTeacher crudRepositoryTeacher;
    
    public ServiceTeacherImpl(RepositoryTeacher crudRepositoryTeacher){
        this.crudRepositoryTeacher = crudRepositoryTeacher;
    }
}
