package com.ceviz.service;

import com.ceviz.model.DepartmentDto;
import com.ceviz.model.SpendDto;

public interface DepartmentService {

    DepartmentDto add(DepartmentDto dto);

    DepartmentDto update(DepartmentDto dto);

    DepartmentDto addSpend(SpendDto spendDto);

}
