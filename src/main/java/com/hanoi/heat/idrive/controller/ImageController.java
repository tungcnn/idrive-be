package com.hanoi.heat.idrive.controller;

import com.hanoi.heat.idrive.model.Image;
import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.repository.ImageRepo;
import com.hanoi.heat.idrive.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<Iterable<Image>> getAll() {
        return new ResponseEntity<>(imageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Iterable<Image>> getAllByVehicle(@PathVariable("id") Long id) {
        return new ResponseEntity<>(imageService.findAllByVehicle(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> findById(@PathVariable("id") Long id) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(imageOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Image> addImage(@RequestBody Image image) {
        return new ResponseEntity<>(imageService.save(image), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        imageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<?> deleteAllPhotoOfVehicle(@PathVariable("id") Long id) {
        imageService.deletePhotoOfVehicle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
