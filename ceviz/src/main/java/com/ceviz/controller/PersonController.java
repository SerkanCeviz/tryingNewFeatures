package com.ceviz.controller;

import com.ceviz.constant.ApiConstants;
import com.ceviz.model.PersonDto;
import com.ceviz.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.PERSON_URL)
@CrossOrigin
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    ResponseEntity<PersonDto> add(@Valid @RequestBody PersonDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<PersonDto> update(@Valid @RequestBody PersonDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }

    @GetMapping(ApiConstants.VARIABLE_ID)
    ResponseEntity<Set<PersonDto>> getPersonByCompanyId(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getPersonByCompanyId(id), HttpStatus.OK);
    }
}
