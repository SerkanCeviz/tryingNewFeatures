package com.ceviz.mapper;

import com.ceviz.entity.Company;
import com.ceviz.entity.Department;
import com.ceviz.model.CompanyDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = DepartmentMapper.class)
public interface CompanyMapper extends BaseMapper<CompanyDto, Company> {

    @AfterMapping
    default void setParentToChild(@MappingTarget Company company) {
        if (Objects.nonNull(company.getDepartments())) {
            for (Department item : company.getDepartments()) {
                item.setCompany(company);
            }
        }
    }
}
