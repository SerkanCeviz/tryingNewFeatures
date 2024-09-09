package com.ceviz.repository;

import com.ceviz.entity.PersonRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRedisRepository extends CrudRepository<PersonRedis, UUID> {
}
