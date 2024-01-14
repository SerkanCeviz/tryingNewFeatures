package com.ceviz.mapper;

import com.ceviz.entity.Person;
import com.ceviz.model.PersonDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.beans.BeanUtils;

import java.util.Objects;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = RoleMapper.class)
public interface PersonMapper extends BaseMapper<PersonDto, Person> {
    @AfterMapping
    default void setRole(@MappingTarget Person person) {
        if (Objects.nonNull(person.getRole())) {
            person.getRole().setPerson(person);
        }
    }

    default void updateDto(PersonDto dbDto, PersonDto dto) {
        BeanUtils.copyProperties(dto, dbDto, "id", "identificationNumber");
    }

    Set<PersonDto> entitySetToDtoSet(Set<Person> personSet);
}
