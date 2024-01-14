package com.ceviz.controller;

import com.ceviz.constant.ApiConstants;
import com.ceviz.model.RoleDto;
import com.ceviz.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstants.ROLE_URL)
@CrossOrigin
public class RoleController {

    private final RoleService service;

    @PostMapping
    ResponseEntity<RoleDto> add(@Valid @RequestBody RoleDto dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.CREATED);
    }
}
