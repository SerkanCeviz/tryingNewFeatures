package com.ceviz.service.impl;

import com.ceviz.constant.Messages;
import com.ceviz.mapper.CompanyMapper;
import com.ceviz.model.CompanyDto;
import com.ceviz.model.SpendDto;
import com.ceviz.repository.CompanyRepository;
import com.ceviz.service.CompanyService;
import com.ceviz.service.validator.CompanyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;
    private final CompanyValidator validator;

    @Override
    public CompanyDto add(CompanyDto dto) {
        validator.isCompanyBudgetGreaterThanorEqualsDepartmentsBudget(dto);
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public CompanyDto addSpend(SpendDto spendDto) {
        CompanyDto dbDto = mapper.entityToDto(
                repository.findById(spendDto.getId()).orElseThrow(() -> new RuntimeException(Messages.NOT_FOUND)));
        dbDto.setSpend(dbDto.getSpend().add(spendDto.getSpend()));
        validator.spendCheck(dbDto);
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dbDto)));
    }
}
