package com.nicoardizzoli.springbootmasterclassv2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Course")
public class Course {

    @Id
    @SequenceGenerator(name = "course_id_seq", sequenceName = "course_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_seq")
    @Column(name = "course_id")
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", foreignKey = @ForeignKey(name = "course_teacher_id_fk"))
    private Teacher teacher;


    @ManyToMany()
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "course_id"
            ),

            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "student_id"
            )
    )
    private List<Student> students;
}
