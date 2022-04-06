package com.nicoardizzoli.springbootmasterclassv2.repository;

import com.nicoardizzoli.springbootmasterclassv2.entity.Guardian;
import com.nicoardizzoli.springbootmasterclassv2.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest no hace el rollback del insert
@DataJpaTest //Hace el rollback de la transaction.
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveStudent() {
        Student student = Student.builder()
                .emailId("nardizzoli@gmail.com")
                .firstName("Nicolas")
                .lastName("Ardizzoli")
                .build();

        studentRepository.save(student);
        assertNotNull(student.getStudentId());

    }
    @Test
    void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("guardian@gmail.com")
                .mobile("2216554133")
                .name("guardian")
                .build();


        Student student = Student.builder()
                .emailId("nardizzoli@gmail.com")
                .firstName("Nicolas")
                .lastName("Ardizzoli")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
        assertNotNull(student.getStudentId());
    }
}