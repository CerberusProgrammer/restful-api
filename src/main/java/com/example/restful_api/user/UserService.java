package com.example.restful_api.user;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByParams(UserQueryParams params) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Predicate predicate = cb.conjunction();

        if (params.getName() != null && !params.getName().isEmpty()) {
            predicate = cb.and(predicate, cb.like(root.get("name"), "%" + params.getName() + "%"));
        }

        if (params.getEmail() != null && !params.getEmail().isEmpty()) {
            predicate = cb.and(predicate, cb.like(root.get("email"), "%" + params.getEmail() + "%"));
        }

        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }
}