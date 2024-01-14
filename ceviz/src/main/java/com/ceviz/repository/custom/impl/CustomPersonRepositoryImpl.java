package com.ceviz.repository.custom.impl;

import com.ceviz.entity.Company;
import com.ceviz.entity.Department;
import com.ceviz.entity.Person;
import com.ceviz.repository.custom.CustomPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomPersonRepositoryImpl implements CustomPersonRepository {

    private final EntityManager entityManager;

    @Override
    public Set<Person> getPersonByCompanyId(UUID companyId) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        Join<Person, Department> departmentJoin = root.join("department");
        Join<Department, Company> companyJoin = departmentJoin.join("company");
        Predicate predicate = criteriaBuilder.equal(companyJoin.get("id"), companyId);
        criteriaQuery.select(root).where(predicate);

        return new HashSet<>(entityManager.createQuery(criteriaQuery).getResultList());
    }

}
