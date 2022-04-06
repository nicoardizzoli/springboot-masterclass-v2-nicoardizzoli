package com.nicoardizzoli.springbootmasterclassv2.repository;

import com.nicoardizzoli.springbootmasterclassv2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

     List<Student> findStudentByFirstName(String firstName);

     List<Student> findStudentByFirstNameContaining(String charactersFirstName);

     //JPQL
     @Query("select s from Student s where s.emailId = ?1")
     Student findStudentByEmailAddress(String email);

    //JPQL
     @Query("select s.firstName from Student s where s.emailId = ?1")
     String findStudentFirstNameByEmailAddress(String email);

     //NATIVE QUERY.
    @Query(value = "SELECT * FROM STUDENT S WHERE S.EMAIL_ID = ?1", nativeQuery = true)
    Student findStudentByEmailAddressNative(String email);

    @Query(value = "SELECT * FROM STUDENT S WHERE S.EMAIL_ID = :email", nativeQuery = true)
    Student findStudentByEmailAddressNativeWithNamedParams(@Param("email") String email);

    //para modificar un dato en particular:
    @Modifying
    @Transactional
    @Query(value = "update student set first_name = :firstName where email_id = :email", nativeQuery = true)
    int updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("email") String emailId);

}
