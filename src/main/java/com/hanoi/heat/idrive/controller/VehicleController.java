package com.hanoi.heat.idrive.controller;

import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<Iterable<Vehicle>> getAllVehicle() {
        List<Vehicle> vehicles = (List<Vehicle>) vehicleService.findAll();
        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/page/{pageNo}")
    public ResponseEntity<Iterable<Vehicle>> getVehiclePage(@PathVariable("pageNo") int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 10);
        Page<Vehicle> vehiclePage = vehicleService.findAll(pageable);
        Iterable<Vehicle> vehicles = vehiclePage.getContent();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> addNewVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editVehicle(@RequestBody Vehicle vehicle, @PathVariable("id") Long id) {
        Optional<Vehicle> vehicleOptional = vehicleService.findById(id);
        if (!vehicleOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vehicleService.save(vehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("id") Long id) {
        Optional<Vehicle> vehicleOptional = vehicleService.findById(id);
        if (!vehicleOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vehicleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
