package com.nicoardizzoli.springbootmasterclassv2.repository;

import com.nicoardizzoli.springbootmasterclassv2.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
