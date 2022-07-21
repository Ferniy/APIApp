package com.example.ProjectX.repository;

import com.example.ProjectX.entity.ClothesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothesRepo extends CrudRepository<ClothesEntity, Integer> {
    List<ClothesEntity> findByUserIdOrderByRating(Integer userId);
    List<ClothesEntity> findByUserIdAndClothesTypeOrderByRating(Integer userId, String clothesType);
    List<ClothesEntity> findByUserIdAndClothesTypeAndColorOrderByRating(Integer userId, String clothesType, String color);
}
