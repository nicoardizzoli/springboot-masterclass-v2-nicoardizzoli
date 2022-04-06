package com.nicoardizzoli.springbootmasterclassv2.repository;

import com.nicoardizzoli.springbootmasterclassv2.entity.Course;
import com.nicoardizzoli.springbootmasterclassv2.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher(){
        Course it = Course.builder()
                .title("IT")
                .credit(10)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Nicolas")
                .lastName("Ardizzoli")
                .courses(List.of(it))
                .build();

        teacherRepository.save(teacher);
    }
}