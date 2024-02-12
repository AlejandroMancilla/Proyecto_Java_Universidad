package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Department;

public interface RepositoryDepartment {
    List<Department> list();

    Department getDepartment(int departmentId);

    void create(Department department);

    void modify(Department department);

    void delete(Department department);

}
