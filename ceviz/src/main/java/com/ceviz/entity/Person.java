package com.ceviz.entity;

import com.ceviz.constant.Messages;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "id_number", nullable = false)
    private String identificationNumber;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "adress", nullable = false)
    private String adress;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToOne(mappedBy = "person",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Role role;

    @ManyToOne
    private Department department;
}
