package com.hanoi.heat.idrive.controller;

import com.hanoi.heat.idrive.model.Location;
import com.hanoi.heat.idrive.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<Iterable<Location>> getAll() {
        return new ResponseEntity<>(locationService.findAll(), HttpStatus.OK);
    }
}
