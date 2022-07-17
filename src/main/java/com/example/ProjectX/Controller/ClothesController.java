package com.example.ProjectX.Controller;

import com.example.ProjectX.entity.ClothesEntity;
import com.example.ProjectX.exceptions.ClothesNotExistException;
import com.example.ProjectX.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @GetMapping
    public ResponseEntity getAllClothes(){
        return ResponseEntity.ok(clothesService.getAllClothes());
    }

    @PostMapping("/addclothes")
    public ResponseEntity addClothes(@RequestBody ClothesEntity clothes) {
        try {
            clothesService.addClothes(clothes);
            return ResponseEntity.ok("Clothes successfully added");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClothes(@PathVariable("id") Integer id, @RequestBody ClothesEntity clothes){
        try{
            clothesService.updateClothes(id, clothes);
            return ResponseEntity.ok("User successfully updated");
        }
        catch (ClothesNotExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClothes(@PathVariable("id") Integer id){
        try{
            clothesService.deleteClothes(id);
            return ResponseEntity.ok("Clothes successfully deleted");
        }
        catch (ClothesNotExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
