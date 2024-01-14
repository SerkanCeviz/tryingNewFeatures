package com.ceviz.service.impl;

import com.ceviz.mapper.RoleMapper;
import com.ceviz.model.RoleDto;
import com.ceviz.repository.RoleRepository;
import com.ceviz.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public RoleDto add(RoleDto roleDto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(roleDto)));
    }
}
