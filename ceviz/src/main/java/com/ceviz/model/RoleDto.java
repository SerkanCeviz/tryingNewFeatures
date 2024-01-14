package com.ceviz.model;

import com.ceviz.constant.Messages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.ceviz.entity.Role}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {

    private UUID id;

    @NotBlank(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private String name;

    private PersonDto person;
}