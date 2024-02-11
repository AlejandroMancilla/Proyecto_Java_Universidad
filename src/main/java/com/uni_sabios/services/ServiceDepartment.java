package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.DepartmentNotFoundException;
import com.uni_sabios.repository.models.Department;

public interface ServiceDepartment {
    List<Department> list();

    Department getCourse(String Code) throws DepartmentNotFoundException;

    void create(Department department);

    void modify(Department department);

    void delete(Department department);
}
