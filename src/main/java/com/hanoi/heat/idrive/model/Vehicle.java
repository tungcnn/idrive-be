package com.hanoi.heat.idrive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    @ManyToOne
    private VehicleType vehicleType;

    @ManyToOne
    private Location location;

    private String brand;

    private Long price;

    private String description;

    private String imgUrl;

    private String license;

}
