package com.nicoardizzoli.springbootmasterclassv2.service;

import com.nicoardizzoli.springbootmasterclassv2.entity.Department;
import com.nicoardizzoli.springbootmasterclassv2.exceptions.DepartmentNotFoundException;
import com.nicoardizzoli.springbootmasterclassv2.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
    }

    @Override
    public String deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted successfully";
    }

    @Override
    public Department updateDepartment(Long id, Department department) throws DepartmentNotFoundException {
        Department departmentById = this.getDepartmentById(id);
        departmentById.setAddress(department.getAddress());
        departmentById.setCode(department.getCode());
        departmentById.setName(department.getName());
        return departmentRepository.save(departmentById);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
}
