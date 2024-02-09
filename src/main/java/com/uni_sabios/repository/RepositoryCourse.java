package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Course;

public interface RepositoryCourse {
    
    List<Course> list();

    Course getClassroom(String Code);

    void create(Course course);

    void edit(Course course);

    void delete(Course course);
}
