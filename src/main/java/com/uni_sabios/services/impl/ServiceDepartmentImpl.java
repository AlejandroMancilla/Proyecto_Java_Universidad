package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.departmentexceptions.DepartmentNullException;
import com.uni_sabios.repository.models.Department;
import com.uni_sabios.services.ServiceDepartment;

public class ServiceDepartmentImpl implements ServiceDepartment{

    @Override
    public List<Department> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public Department getCourse(String Code) throws DepartmentNullException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourse'");
    }

    @Override
    public void create(Department department) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void modify(Department department) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public void delete(Department department) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
