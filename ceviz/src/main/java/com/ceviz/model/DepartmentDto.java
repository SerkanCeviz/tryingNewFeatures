package com.ceviz.model;

import com.ceviz.constant.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.ceviz.entity.Department}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto implements Serializable {

    private UUID id;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private String name;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private BigDecimal budget;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private BigDecimal spend;

    private Set<PersonDto> crew;

    private CompanyDto company;
}