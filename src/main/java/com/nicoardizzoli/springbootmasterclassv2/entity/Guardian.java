package com.nicoardizzoli.springbootmasterclassv2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable //Sirve para mappear ciertos atributos de una clase, en otra clase diferente pero usando la misma tabla
@AttributeOverride(
        name = "name",
        column = @Column(name = "guardian_name")
)
@AttributeOverride(
        name = "email",
        column = @Column(name = "guardian_email")
)
@AttributeOverride(
        name = "mobile",
        column = @Column(name = "guardian_mobile")
)
public class Guardian {

    private String name;

    private String email;

    private String mobile;
}
