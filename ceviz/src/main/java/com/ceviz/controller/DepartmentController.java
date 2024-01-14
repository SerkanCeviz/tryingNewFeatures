package com.ceviz.controller;

import com.ceviz.constant.ApiConstants;
import com.ceviz.model.DepartmentDto;
import com.ceviz.model.SpendDto;
import com.ceviz.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(ApiConstants.DEPARTMENT_URL)
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping
    ResponseEntity<DepartmentDto> addCompany(@Valid @RequestBody DepartmentDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<DepartmentDto> update(@Valid @RequestBody DepartmentDto dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }

    @PutMapping(ApiConstants.ADD_SPEND)
    ResponseEntity<DepartmentDto> addSpend(@Valid @RequestBody SpendDto dto) {
        return new ResponseEntity<>(service.addSpend(dto), HttpStatus.OK);
    }
}
