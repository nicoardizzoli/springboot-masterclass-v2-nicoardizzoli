package com.nicoardizzoli.springbootmasterclassv2.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    /*
    @Length(max = 10, min = 1)
    @Size(max = 10, min = 1)
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    @Future
    @FutureOrPresent
    si queremos ver mas validaciones podemos ver el paquete haciendo click en unaa de las etiquetas y viendo el costado.
    */
    @NotBlank(message = "Please add department name") //ESTO ES HIBERNATE VALIDATION, ESTAN EN EL STARTER DE VALIDATION DE SPRING (agregar dependencia)
    private String name;

    private String address;

    private String code;
}
