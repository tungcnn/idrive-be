package com.hanoi.heat.idrive.controller;

import com.hanoi.heat.idrive.model.Location;
import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.model.VehicleType;
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

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") Long id) {
        Optional<Vehicle> vehicleOptional = vehicleService.findById(id);
        if (!vehicleOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vehicleOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/findByLocation/{id}")
    public ResponseEntity<Iterable<Vehicle>> getVehicleByLocation(@PathVariable Long id) {
        List<Vehicle> vehicles = (List<Vehicle>) vehicleService.findVehicleByLocation(vehicleService.findById(id).get().getLocation());
        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/findByVehicleType/{id}")
    public ResponseEntity<Iterable<Vehicle>> getVehicleByVehicleType(@PathVariable Long id) {
        List<Vehicle> vehicles = (List<Vehicle>) vehicleService.findVehicleByVehicleType(vehicleService.findById(id).get().getVehicleType());
        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/findByBoth")
    public ResponseEntity<Iterable<Vehicle>> getVehicleByLocationAndVehicleType(@RequestBody Location location, @RequestBody VehicleType vehicleType) {
        List<Vehicle> vehicles = (List<Vehicle>) vehicleService.findVehicleByLocationAndVehicleType(location, vehicleType);
        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> addNewVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> editVehicle(@RequestBody Vehicle vehicle) {
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
