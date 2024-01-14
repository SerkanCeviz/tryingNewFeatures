package com.ceviz.service.validator;

import com.ceviz.constant.Messages;
import com.ceviz.model.DepartmentDto;
import com.ceviz.model.PersonDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DepartmentValidator {

    public void isDepartmentBudgetGreaterThanOrEqualsCrewSalary(DepartmentDto dto) {
        BigDecimal crewSalary = dto.getCrew().stream().
                map(PersonDto::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
        if (dto.getBudget().compareTo(crewSalary) < 0) {
            throw new RuntimeException(Messages.DEPARTMENT_BUDGET_CANNOT_BE_LOWER_THAN_CREW_SALARY);
        }
    }

    public void spendCheck(DepartmentDto dto) {
        if (dto.getSpend().compareTo(dto.getBudget()) > 0) {
            throw new RuntimeException(Messages.SPEND_MUST_BE_LOWER_THAN_BUDGET);
        }
    }
}
