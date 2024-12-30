package com.portal.api.service;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    private CarPostStoreClient carPostStoreClient;


    @Override
    public void createOwnerCar(OwnerPostDTO dto) {

    }
}
