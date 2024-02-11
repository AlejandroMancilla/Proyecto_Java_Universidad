package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.courseexceptions.CourseNullException;
import com.uni_sabios.repository.RepositoryCourse;
import com.uni_sabios.repository.models.Course;
import com.uni_sabios.services.ServiceCourse;

public class ServiceCourseImpl implements ServiceCourse{
    
    private final RepositoryCourse crudRepositoryCourse;

    public ServiceCourseImpl(RepositoryCourse crudRepositoryCourse){
        this.crudRepositoryCourse = crudRepositoryCourse;
    }

    @Override
    public List<Course> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public Course getCourse(String Code) throws CourseNullException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourse'");
    }

    @Override
    public void create(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void modify(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public void delete(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
