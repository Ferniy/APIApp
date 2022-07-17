package com.example.ProjectX.repository;

import com.example.ProjectX.entity.ClothesEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClothesRepo extends CrudRepository<ClothesEntity, Integer> {
}
