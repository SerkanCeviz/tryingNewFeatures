package com.ceviz.model;

import com.ceviz.constant.Messages;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class SpendDto {

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private UUID id;

    @NotNull(message = Messages.FIELD_NOT_NULL_NOT_BLANK_MESSAGE)
    private BigDecimal spend;
}
