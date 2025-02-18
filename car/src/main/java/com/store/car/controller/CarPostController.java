package com.store.car.controller;

import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @PostMapping
    public ResponseEntity postCar(@RequestBody  CarPostDTO dto){
        carPostService.newPostDetails(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getCarPosts(){
        carPostService.getCarSales();
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/car/{id}")
    public ResponseEntity updateCarPost(@RequestBody CarPostDTO dto, @PathVariable("id") String id){
        carPostService.changeCarSale(dto, Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity deleteCarPost(@PathVariable("id") String id){
        carPostService.removeCarSale(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }
}
