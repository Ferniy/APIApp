package com.example.ProjectX.model;

import com.example.ProjectX.entity.UserEntity;

public class User {
    private String username;
    private String password;

    public static User toModel(UserEntity userEntity){
        User user = new User();
        user.username = userEntity.getUsername();
        user.password = userEntity.getPassword();
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
