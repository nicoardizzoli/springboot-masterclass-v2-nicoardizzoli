package com.nicoardizzoli.springbootmasterclassv2.controller;

import com.nicoardizzoli.springbootmasterclassv2.entity.Department;
import com.nicoardizzoli.springbootmasterclassv2.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//esto es para testear Controllers
@WebMvcTest(controllers = DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .address("Address testing")
                .code("ME-011")
                .name("Mechanical Engineering")
                .id(1L)
                .build();
    }

    @Test
    @DisplayName("Save department")
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .address("Address testing")
                .code("ME-011")
                .name("Mechanical Engineering")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/v1/masterclass/save-department")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \t\"name\":\"Mechanical Engineering\",\n" +
                                "    \t\"address\":\"Address testing\",\n" +
                                "    \t\"code\":\"ME-011\"\n" +
                                "       }"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/masterclass/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(department.getName()));
    }
}