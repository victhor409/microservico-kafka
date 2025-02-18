package com.store.car.controller;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping("/owner")
    public ResponseEntity postOwner(@RequestBody OwnerPostDTO dto) {
        ownerPostService.createOwnerPost(dto);
        return ResponseEntity.ok().build();
    }
}
