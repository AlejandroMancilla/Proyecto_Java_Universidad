package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.courseexceptions.CourseNullException;
import com.uni_sabios.repository.models.Course;

public interface ServiceCourse {
    List<Course> list();

    Course getCourse(int courseId) throws CourseNullException;

    void create(Course course);

    void modify(Course course);

    void delete(Course course);
}