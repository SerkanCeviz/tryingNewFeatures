package com.ceviz.entity;

import com.ceviz.constant.Messages;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@Entity
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "taxNumber", nullable = false)
    private String taxNumber;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "budget", nullable = false)
    private BigDecimal budget;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    @Column(name = "spend", nullable = false)
    private BigDecimal spend;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Department> departments;
}
