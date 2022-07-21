package com.example.ProjectX.service;

import com.example.ProjectX.entity.ClothesEntity;
import com.example.ProjectX.exceptions.ClothesNotExistException;
import com.example.ProjectX.exceptions.UserNotExistException;
import com.example.ProjectX.repository.ClothesRepo;
import com.example.ProjectX.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesService {

    @Autowired
    private ClothesRepo clothesRepo;

    @Autowired
    private UserRepo userRepo;

    public Iterable<ClothesEntity> getAllClothes(){
        return clothesRepo.findAll();
    }

    public Iterable<ClothesEntity> getClothesByUser(Integer userId) throws UserNotExistException {
        if (userRepo.findById((userId)).isEmpty())
            throw new UserNotExistException("User not exist");
        return clothesRepo.findByUserIdOrderByRating(userId);
    }

    public Iterable<ClothesEntity> getClothesByUserAndType(Integer userId, String clothesType) throws UserNotExistException {
        if (userRepo.findById((userId)).isEmpty())
            throw new UserNotExistException("User not exist");
        return clothesRepo.findByUserIdAndClothesTypeOrderByRating(userId, clothesType);
    }

    public Iterable<ClothesEntity> getClothesByUserAndTypeAndColor(Integer userId, String clothesType, String color) throws UserNotExistException {
        if (userRepo.findById((userId)).isEmpty())
            throw new UserNotExistException("User not exist");
        return clothesRepo.findByUserIdAndClothesTypeAndColorOrderByRating(userId, clothesType, color);
    }

    public void addClothes(ClothesEntity clothes) {
        clothesRepo.save(clothes);
    }

    public void updateClothes(Integer id, ClothesEntity clothes) throws ClothesNotExistException {
        if (clothesRepo.findById(id).isEmpty())
            throw new ClothesNotExistException("Clothes not exist");

        ClothesEntity clothesToUpdate = clothesRepo.findById(id).get();
        clothesToUpdate.setUserId(clothes.getUserId());
        clothesToUpdate.setClothesType(clothes.getClothesType());
        clothesToUpdate.setColor(clothes.getColor());
        clothesToUpdate.setPicture(clothes.getPicture());
        clothesToUpdate.setRating(clothes.getRating());
        clothesToUpdate.setIroned(clothes.getIroned());
        clothesToUpdate.setWashed(clothes.getWashed());

        clothesRepo.save(clothesToUpdate);
    }

    public void  deleteClothes(Integer id) throws ClothesNotExistException {
        if (clothesRepo.findById(id).isEmpty())
            throw new ClothesNotExistException("Clothes not exist");
        clothesRepo.deleteById(id);
    }
}
