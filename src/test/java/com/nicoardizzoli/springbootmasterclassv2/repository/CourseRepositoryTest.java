package com.nicoardizzoli.springbootmasterclassv2.repository;

import com.nicoardizzoli.springbootmasterclassv2.entity.Course;
import com.nicoardizzoli.springbootmasterclassv2.entity.CourseMaterial;
import com.nicoardizzoli.springbootmasterclassv2.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Nicolas")
                .lastName("Ardizzoli")
                .build();

        Course course = Course.builder()
                .title("MATHS")
                .credit(1)
                .teacher(teacher)
                .build();


        CourseMaterial courseMa = CourseMaterial.builder()
                .course(course)
                .url("maths.com")
                .build();

        courseRepository.save(course);
    }

    @Test
    void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);

        List<Course> page1 = courseRepository.findAll(firstPageWithThreeRecords).getContent();

    }

    @Test
    void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
    }


    @Test
    void findByTitleContaining(){
        Pageable pageable = PageRequest.of(0, 2);
        List<Course> listCourses = courseRepository.findCourseByTitleContaining("D", pageable);
        System.out.println(listCourses);
    }
}