package com.salman;

import io.micronaut.http.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

@Controller("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Get("/{id}")
    public User findById(@NotNull int id){
        return userService.findById(id);
    }

    @Post("/{name},{username},{age},{email}")
    public boolean save(@PathVariable("name") String name,@PathVariable("username") String surname,
                        @PathVariable("age")int age, @PathVariable("email")String email){
        return userService.save(name, surname, age, email);
    }

    @Delete("/{id}")
    public boolean deleteById(@NotNull int id) {
        return userService.deleteById(id);
    }
}
