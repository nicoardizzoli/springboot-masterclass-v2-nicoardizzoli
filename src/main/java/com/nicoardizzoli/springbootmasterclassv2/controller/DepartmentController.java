package com.nicoardizzoli.springbootmasterclassv2.controller;

import com.nicoardizzoli.springbootmasterclassv2.entity.Department;
import com.nicoardizzoli.springbootmasterclassv2.exceptions.DepartmentNotFoundException;
import com.nicoardizzoli.springbootmasterclassv2.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/masterclass")
@AllArgsConstructor
@Slf4j
public class DepartmentController {

    //Inversion Of Control: Cederle el control a spring de la creacion de objetos, se invierte el control,
    // antes teniamos q hacer el new, ahora le damos el control a spring


    //Hay dos formas de DI por constructor o por el autowired (CON LOMBOK SIEMPRE TIENE Q TENER EL PRIVATE FINAL).
    private final DepartmentService departmentService;

    //si no tenemos lombok podemos agregar el logger asi:
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/save-department")
    @ResponseStatus(HttpStatus.OK)
    public Department saveDepartment(@Valid @RequestBody Department department) {
        //El @Valid valida con hibernate validations que este completo el requermiento segun los datos requeridos de department que tengan el NotBlank
        log.info("GUARDANDO DEPARTMENT");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }


    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable Long id) {
        return departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) throws DepartmentNotFoundException {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable String name){
        return departmentService.getDepartmentByName(name);
    }

}
