package com.nicoardizzoli.springbootmasterclassv2.service;


import com.nicoardizzoli.springbootmasterclassv2.entity.Department;
import com.nicoardizzoli.springbootmasterclassv2.exceptions.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    String deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department) throws DepartmentNotFoundException;

    Department getDepartmentByName(String name);
}
