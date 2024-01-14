package com.ceviz.service.impl;

import com.ceviz.constant.Messages;
import com.ceviz.mapper.PersonMapper;
import com.ceviz.model.PersonDto;
import com.ceviz.repository.PersonRepository;
import com.ceviz.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    @Override
    public PersonDto add(PersonDto dto) {
        if (repository.findByIdentificationNumber(dto.getIdentificationNumber()).isPresent()) {
            throw new RuntimeException(Messages.PERSON_EXIST);
        }
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public PersonDto update(PersonDto dto) {
        PersonDto dbDto = mapper.entityToDto(repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException(Messages.NOT_FOUND)));
        mapper.updateDto(dbDto, dto);
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dbDto)));
    }

    @Override
    public Set<PersonDto> getPersonByCompanyId(UUID companyId) {
        return mapper.entitySetToDtoSet(repository.getPersonByCompanyId(companyId));
    }

//    @Override
//    public boolean isPersonWorking(Set<UUID> id) {
//        return false;
//    }
//
//    @Override
//    public boolean isPersonWorking(Set<UUID> id, UUID companyId) {
//        return false;
//    }
}
