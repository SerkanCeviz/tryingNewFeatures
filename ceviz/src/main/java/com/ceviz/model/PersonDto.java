package com.ceviz.model;

import com.ceviz.constant.Messages;
import com.ceviz.entity.Department;
import com.ceviz.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO for {@link com.ceviz.entity.Person}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto implements Serializable {

    private UUID id;

    private String identificationNumber;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private String name;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private String surname;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private BigDecimal salary;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private String adress;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private String phoneNumber;

    private Role role;

    private Department department;
}