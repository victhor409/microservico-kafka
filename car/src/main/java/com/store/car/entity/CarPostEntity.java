package com.store.car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "car_post")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_price")
    private Double price;

    @Column(name = "car_description")
    private String description;

    @Column(name = "car_egine_version")
    private String engineVersion;

    @Column(name = "car_city")
    private String city;

    @Column(name = "car_created_Date")
    private String createdDate;

    @Column(name = "car_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity owner;
}
