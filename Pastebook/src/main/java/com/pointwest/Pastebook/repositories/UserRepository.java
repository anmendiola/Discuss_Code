package com.pointwest.Pastebook.repositories;

import com.pointwest.Pastebook.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Object> {
    User findByEmail(String email);
}
