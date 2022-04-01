package com.nicoardizzoli.springbootmasterclassv2.repository;

import com.nicoardizzoli.springbootmasterclassv2.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    //Con el testEntityManager lo que logramos es no tener que insertar y borrar en la base de datos manualmente.
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .address("Address testing")
                .code("ME-011")
                .name("Mechanical Engineering")
                .build();
        testEntityManager.persist(department);
    }

    @Test
    void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        Assertions.assertEquals("Mechanical Engineering", department.getName());
    }

}