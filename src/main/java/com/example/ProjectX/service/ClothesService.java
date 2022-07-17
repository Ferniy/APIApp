package com.example.ProjectX.service;

import com.example.ProjectX.entity.ClothesEntity;
import com.example.ProjectX.exceptions.ClothesNotExistException;
import com.example.ProjectX.repository.ClothesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesService {

    @Autowired
    private ClothesRepo clothesRepo;

    public Iterable<ClothesEntity> getAllClothes(){
        return clothesRepo.findAll();
    }

    public void addClothes(ClothesEntity clothes) {
        clothesRepo.save(clothes);
    }

    public void updateClothes(Integer id, ClothesEntity clothes) throws ClothesNotExistException {
        if (clothesRepo.findById(id).isEmpty())
            throw new ClothesNotExistException("User not exist");

        ClothesEntity clothesToUpdate = clothesRepo.findById(id).get();
        clothesToUpdate.setClothesType(clothes.getClothesType());
        clothesToUpdate.setColor(clothes.getColor());
        clothesToUpdate.setName(clothes.getName());
        clothesToUpdate.setPicture(clothes.getPicture());
        clothesToUpdate.setRating(clothes.getRating());
        clothesToUpdate.setIroned(clothes.getIroned());
        clothesToUpdate.setWashed(clothes.getWashed());

        clothesRepo.save(clothesToUpdate);
    }

    public void  deleteClothes(Integer id) throws ClothesNotExistException {
        if (clothesRepo.findById(id).isEmpty())
            throw new ClothesNotExistException("User not exist");
        clothesRepo.deleteById(id);
    }
}
