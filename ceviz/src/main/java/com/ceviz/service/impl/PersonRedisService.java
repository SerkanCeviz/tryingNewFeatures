package com.ceviz.service.impl;

import com.ceviz.entity.PersonRedis;
import com.ceviz.mapper.PersonMapper;
import com.ceviz.model.PersonDto;
import com.ceviz.repository.PersonRedisRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonRedisService {
    private final PersonRedisRepository personRedisRepository;
    private final PersonMapper mapper;

    public PersonRedisService(PersonRedisRepository personRedisRepository, PersonMapper mapper) {
        this.personRedisRepository = personRedisRepository;
        this.mapper = mapper;
    }

    public void savePersonToRedis(PersonDto person) {
        personRedisRepository.save(mapper.personToRedis(person));
    }

    public PersonDto getPersonDto(UUID id) {
        return mapper.redisToPersonDto(personRedisRepository.findById(id).orElse(new PersonRedis()));
    }
}
