package com.ceviz.service;

import com.ceviz.model.CompanyDto;
import com.ceviz.model.SpendDto;

public interface CompanyService {
    CompanyDto add(CompanyDto dto);

    CompanyDto addSpend(SpendDto spendRecord);
}
