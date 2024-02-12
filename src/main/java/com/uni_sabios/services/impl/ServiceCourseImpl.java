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
        return this.crudRepositoryCourse.list();
    }

    @Override
    public Course getCourse(int courseId) throws CourseNullException {
        Course course = this.crudRepositoryCourse.getCourse(courseId);
        if(course != null){
            return course;
        }else{
            throw new CourseNullException("No Course with this id was found");
        }
    }

    @Override
    public void create(Course course) {
        this.crudRepositoryCourse.create(course);
    }

    @Override
    public void modify(Course course) {
        this.crudRepositoryCourse.modify(course);
    }

    @Override
    public void delete(Course course) {
        this.crudRepositoryCourse.delete(course);
    }
}
