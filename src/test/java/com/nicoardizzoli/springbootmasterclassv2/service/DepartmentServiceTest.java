package com.nicoardizzoli.springbootmasterclassv2.service;

import com.nicoardizzoli.springbootmasterclassv2.entity.Department;
import com.nicoardizzoli.springbootmasterclassv2.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach //este se llama antes de cada uno osea por cada test hace una llamada
//    @BeforeAll //se llama una sola vez y sirve para todos los test.
    void setUp(){

        Department department = Department.builder()
                .name("IT")
                .address("address test")
                .id(1L)
                .code("23-IT")
                .build();

        Mockito.when(departmentRepository.findByName("IT")).thenReturn(department);

    }

    //testeando unicamente la capa controller (usando mockito para que no se use el repository real)
    @Test
    @DisplayName("Get data based oin valid department name")
    void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department departmentByName = departmentService.getDepartmentByName(departmentName);

        Assertions.assertEquals(departmentName, departmentByName.getName());

    }
}