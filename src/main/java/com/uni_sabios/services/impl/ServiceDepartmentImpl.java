package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.departmentexceptions.DepartmentNullException;
import com.uni_sabios.repository.RepositoryDepartment;
import com.uni_sabios.repository.models.Department;
import com.uni_sabios.services.ServiceDepartment;

public class ServiceDepartmentImpl implements ServiceDepartment{

    private final RepositoryDepartment crudRepositoryDepartment;

    public ServiceDepartmentImpl(RepositoryDepartment crudRepositoryDepartment) {
        this.crudRepositoryDepartment = crudRepositoryDepartment;
    }
    @Override
    public List<Department> list() {
        return this.crudRepositoryDepartment.list();
    }

    @Override
    public Department getDepartment(int departmentId) throws DepartmentNullException {
        Department department = this.crudRepositoryDepartment.getDepartment(departmentId);
        if(department != null){
            return department;
        }else{
            throw new DepartmentNullException("No program with this id was found");
        }
    }

    @Override
    public void create(Department department) {
        this.crudRepositoryDepartment.create(department);
    }

    @Override
    public void modify(Department department) {
        this.crudRepositoryDepartment.modify(department);
    }

    @Override
    public void delete(Department department) {
        this.crudRepositoryDepartment.delete(department);
    }
    
}
