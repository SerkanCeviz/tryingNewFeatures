package com.ceviz.mapper;

import com.ceviz.entity.Role;
import com.ceviz.model.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper extends BaseMapper<RoleDto, Role> {
}
