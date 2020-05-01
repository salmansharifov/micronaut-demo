package com.salman;

import io.micronaut.context.ApplicationContextConfiguration;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.util.List;
@Singleton
public class UserService implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationContextConfiguration contextConfiguration;

    public UserService(EntityManager entityManager,
                       ApplicationContextConfiguration contextConfiguration) {
        this.entityManager = entityManager;
        this.contextConfiguration = contextConfiguration;
    }

    @Override
    public User findById(@NotNull int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public boolean save(String name, String surname, int age, String email) {
        User user = new User(name, surname, age, email);
        System.out.println(user);
        entityManager.persist(user);
        return true;
    }

    @Override
    public boolean deleteById(@NotNull int id) {
        User user = findById(id);
        System.out.println(user);
        entityManager.remove(user);
        return true;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(String name, String surname, int age, String email) {
        entityManager.createQuery("UPDATE USER set name = :name, surname = :surname, age = :age, email = :email")
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("age", age)
                .setParameter("email", email);
    }
}
