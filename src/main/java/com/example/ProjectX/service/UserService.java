package com.example.ProjectX.service;

import com.example.ProjectX.entity.UserEntity;
import com.example.ProjectX.exceptions.UserAlreadyExistException;
import com.example.ProjectX.exceptions.UserNotExistException;
import com.example.ProjectX.exceptions.UsernameAlreadyExistException;
import com.example.ProjectX.model.User;
import com.example.ProjectX.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Iterable<UserEntity> getUsers(){
        return userRepo.findAll();
    }

    public User getUser(Integer id) throws UserNotExistException {
        if (userRepo.findById((id)).isEmpty())
            throw new UserNotExistException("User not exist");
        return User.toModel(userRepo.getById((id)));
    }

    public void addUser(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null)
            throw new UserAlreadyExistException("User already exist");
        userRepo.save(user);
    }

    public void updateUser(Integer id, UserEntity user) throws UserNotExistException, UsernameAlreadyExistException {
        if (userRepo.findById(id).isEmpty())
            throw new UserNotExistException("User not exist");
        if (userRepo.findByUsername(user.getUsername()) != null)
            throw new UsernameAlreadyExistException("Username already taken");

        UserEntity userToUpdate = userRepo.findById(id).get();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userRepo.save(userToUpdate);
    }

    public void deleteUser(Integer id) throws UserNotExistException {
        if (userRepo.findById(id).isEmpty())
            throw new UserNotExistException("User not exist");
        userRepo.deleteById(id);
    }
}
