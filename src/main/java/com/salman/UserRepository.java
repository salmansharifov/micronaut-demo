package com.salman;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository {
        User findById(@NotNull int id);
        boolean save(String name, String surname, int age, String email);
        boolean deleteById(@NotNull int id);
        List<User> findAll();
        void update(String name, String surname, int age, String email);

}
