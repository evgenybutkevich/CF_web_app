package com.test.repositories;

import com.test.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findByActivationCode(String activationCode);

}
