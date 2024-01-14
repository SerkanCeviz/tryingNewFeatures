package com.ceviz.model;

import com.ceviz.constant.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.ceviz.entity.Company}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto implements Serializable {

    private UUID id;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private String name;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private String taxNumber;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private BigDecimal budget;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private BigDecimal spend;

    private Set<DepartmentDto> departments;
}