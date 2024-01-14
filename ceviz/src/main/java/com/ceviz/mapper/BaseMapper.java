package com.ceviz.mapper;

/**
 * @param <T1> DTO
 * @param <T2> ENTITY
 */

public interface BaseMapper<T1, T2> {
    T2 dtoToEntity(T1 dto);

    T1 entityToDto(T2 ent);
}
