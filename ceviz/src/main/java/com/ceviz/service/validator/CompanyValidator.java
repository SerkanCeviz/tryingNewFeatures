package com.ceviz.service.validator;

import com.ceviz.constant.Messages;
import com.ceviz.model.CompanyDto;
import com.ceviz.model.DepartmentDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CompanyValidator {
    public void isCompanyBudgetGreaterThanorEqualsDepartmentsBudget(CompanyDto dto) {
        BigDecimal departmentsBudget = dto.getDepartments().stream().
                map(DepartmentDto::getBudget).reduce(BigDecimal.ZERO, BigDecimal::add);
        if (dto.getBudget().compareTo(departmentsBudget) < 0) {
            throw new RuntimeException(Messages.COMPANY_BUDGET_CANNOT_BE_LOWER_THAN_DEPARTMENTS_BUDGET);
        }
    }

    public void spendCheck(CompanyDto dto) {
        if (dto.getSpend().compareTo(dto.getBudget()) > 0) {
            throw new RuntimeException(Messages.SPEND_MUST_BE_LOWER_THAN_BUDGET);
        }
    }
}
