package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Course;

public interface RepositoryCourse {
    
    List<Course> list();

    Course getCourse(int courseId);

    void create(Course course);

    void modify(Course course);

    void delete(Course course);
}
