package com.ceviz.controller;

import com.ceviz.constant.ApiConstants;
import com.ceviz.model.CompanyDto;
import com.ceviz.model.SpendDto;
import com.ceviz.service.CompanyService;
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
@RequestMapping(ApiConstants.COMPANY_URL)
@RequiredArgsConstructor
@CrossOrigin
public class CompanyController {
    private final CompanyService service;

    @PostMapping
    ResponseEntity<CompanyDto> addCompany(@Valid @RequestBody CompanyDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping(ApiConstants.ADD_SPEND)
    ResponseEntity<CompanyDto> addSpend(@Valid @RequestBody SpendDto dto) {
        return new ResponseEntity<>(service.addSpend(dto), HttpStatus.OK);
    }
}
