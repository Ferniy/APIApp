package com.example.ProjectX.repository;

import com.example.ProjectX.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity getById(Integer id);
}
