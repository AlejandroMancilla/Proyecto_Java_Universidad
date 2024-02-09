package com.uni_sabios.services;

import java.util.List;


import com.uni_sabios.exceptions.CourseNotFoundException;
import com.uni_sabios.repository.models.Course;

public interface ServiceCourse {
    List<Course> list();

    Course getCourse(String Code) throws CourseNotFoundException;

    void create(Course course);

    void modify(Course course);

    void delete(Course course);
}