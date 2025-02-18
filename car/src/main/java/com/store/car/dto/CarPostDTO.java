package com.store.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude
public class CarPostDTO implements Serializable {

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private String createdDate;
    private Long ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;
}
