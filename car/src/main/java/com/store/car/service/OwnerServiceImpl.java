package com.store.car.service;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OwnerServiceImpl implements OwnerPostService{

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {

        OwnerPostEntity owner = new OwnerPostEntity();

        owner.setName(ownerPostDTO.getName());
        owner.setType(ownerPostDTO.getType());
        owner.setContactNumber(ownerPostDTO.getContactNumber());


        ownerPostRepository.save(owner);
    }
}
