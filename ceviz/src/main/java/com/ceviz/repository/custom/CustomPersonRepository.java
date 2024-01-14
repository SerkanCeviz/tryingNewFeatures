package com.ceviz.repository.custom;

import com.ceviz.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface CustomPersonRepository {
    Set<Person> getPersonByCompanyId(UUID companyId);
}
