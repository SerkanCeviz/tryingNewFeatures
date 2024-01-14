package com.ceviz.service.impl;

import com.ceviz.constant.Messages;
import com.ceviz.mapper.DepartmentMapper;
import com.ceviz.model.DepartmentDto;
import com.ceviz.model.PersonDto;
import com.ceviz.model.SpendDto;
import com.ceviz.repository.DepartmentRepository;
import com.ceviz.service.DepartmentService;
import com.ceviz.service.PersonService;
import com.ceviz.service.validator.DepartmentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;
    private final DepartmentValidator validator;
    private final PersonService personService;

    @Override
    public DepartmentDto add(DepartmentDto dto) {
        validator.isDepartmentBudgetGreaterThanOrEqualsCrewSalary(dto);
//        if (personService.isPersonWorking(dto.getCrew().stream().map(PersonDto::getId).collect(Collectors.toSet()))) {
//            throw new RuntimeException(Messages.PERSON_ALREADY_WORKING);
//        }
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public DepartmentDto update(DepartmentDto dto) {
        validator.isDepartmentBudgetGreaterThanOrEqualsCrewSalary(dto);
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public DepartmentDto addSpend(SpendDto spendDto) {
        DepartmentDto dbDto = mapper.entityToDto(
                repository.findById(spendDto.getId()).orElseThrow(() -> new RuntimeException(Messages.NOT_FOUND)));
        dbDto.setSpend(dbDto.getSpend().add(spendDto.getSpend()));
        validator.spendCheck(dbDto);
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dbDto)));
    }
}
