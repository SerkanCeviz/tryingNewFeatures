package com.ceviz.service;

import com.ceviz.model.PersonDto;

import java.util.Set;
import java.util.UUID;

public interface PersonService {
    PersonDto add(PersonDto dto);

    PersonDto update(PersonDto dto);

    Set<PersonDto> getPersonByCompanyId(UUID companyId);

    PersonDto getById(UUID id);
//    boolean isPersonWorking(Set<UUID> id);
//
//    boolean isPersonWorking(Set<UUID> id, UUID companyId);

}
