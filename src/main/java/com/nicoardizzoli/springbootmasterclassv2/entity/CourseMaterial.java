package com.nicoardizzoli.springbootmasterclassv2.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "CourseMaterial")
@Table(name = "course_material")
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "course_material_id_seq", sequenceName = "course_material_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_id_seq")
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", foreignKey = @ForeignKey(name = "coursematerial_course_id_fk"))
    @ToString.Exclude
    private Course course;
}
