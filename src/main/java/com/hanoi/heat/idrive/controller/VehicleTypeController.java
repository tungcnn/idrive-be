package com.hanoi.heat.idrive.controller;

import com.hanoi.heat.idrive.model.VehicleType;
import com.hanoi.heat.idrive.service.vehicletype.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/vehicle-types")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping
    public ResponseEntity<Iterable<VehicleType>> getAll() {
        return new ResponseEntity<>(vehicleTypeService.findAll(), HttpStatus.OK);
    }
}
