package com.ceviz.repository;

import com.ceviz.entity.Person;
import com.ceviz.repository.custom.CustomPersonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID>, CustomPersonRepository {
    Optional<Person> findByIdentificationNumber(String idNumber);
}
