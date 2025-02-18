package com.store.car.service;


import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPostDTO) {
       CarPostEntity carPostEntity = new CarPostEntity();

       ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresent(item ->{
           carPostEntity.setOwner(item);
           carPostEntity.setContact(item.getContactNumber());
       });

       carPostEntity.setDescription(carPostDTO.getDescription());
       carPostEntity.setPrice(carPostDTO.getPrice());
       carPostEntity.setCity(carPostDTO.getCity());
       carPostEntity.setContact(carPostDTO.getContact());
       carPostEntity.setModel(carPostDTO.getModel());
       carPostEntity.setCreatedDate(String.valueOf(new Date()));
       carPostEntity.setBrand(carPostDTO.getBrand());
       carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());

       return carPostRepository.save(carPostEntity);
    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item ->
        {listCarSales.add(mapCarEntityToDTO(item));});

        return listCarSales;
    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity entity) {
        return CarPostDTO.builder()
                .brand(entity.getBrand())
                .model(entity.getModel())
                .city(entity.getCity())
                .price(entity.getPrice())
                .createdDate(entity.getCreatedDate())
                .description(entity.getDescription())
                .engineVersion(entity.getEngineVersion())
                .contact(entity.getContact())
                .ownerName(entity.getOwner().getName()).build();
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long id) {
        carPostRepository.findById(id).ifPresent(item ->{
            item.setPrice(carPostDTO.getPrice());
            item.setCreatedDate(carPostDTO.getCreatedDate());
            item.setDescription(carPostDTO.getDescription());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setContact(carPostDTO.getContact());
            item.setBrand(carPostDTO.getBrand());
            item.setModel(carPostDTO.getModel());

            carPostRepository.save(item);
        });
    }

    @Override
    public void removeCarSale(Long id) {
        carPostRepository.deleteById(id);
    }
}
