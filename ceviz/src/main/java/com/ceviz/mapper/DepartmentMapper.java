package com.ceviz.mapper;

import com.ceviz.entity.Department;
import com.ceviz.entity.Person;
import com.ceviz.model.DepartmentDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = PersonMapper.class)
public interface DepartmentMapper extends BaseMapper<DepartmentDto, Department> {

    @AfterMapping
    default void setParentToChild(@MappingTarget Department department) {
        if (Objects.nonNull(department.getCrew())) {
            for (Person person : department.getCrew()) {
                person.setDepartment(department);
            }
        }
    }
}
