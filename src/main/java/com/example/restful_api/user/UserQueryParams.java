package com.example.restful_api.user;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class UserQueryParams {
    private String name;
    private String email;

    public Predicate toPredicate(CriteriaBuilder cb, Root<User> root) {
        Predicate predicate = cb.conjunction();

        if (name != null && !name.isEmpty()) {
            predicate = cb.and(predicate, cb.like(root.get("name"), "%" + name + "%"));
        }

        if (email != null && !email.isEmpty()) {
            predicate = cb.and(predicate, cb.like(root.get("email"), "%" + email + "%"));
        }

        return predicate;
    }
}