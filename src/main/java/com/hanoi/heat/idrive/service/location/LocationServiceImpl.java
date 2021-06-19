package com.hanoi.heat.idrive.service.location;

import com.hanoi.heat.idrive.model.Location;
import com.hanoi.heat.idrive.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationRepo locationRepo;

    @Override
    public Page<Location> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Location> findAll() {
        return locationRepo.findAll();
    }

    @Override
    public Location save(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Optional<Location> findById(Long id) {
        return locationRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        locationRepo.deleteById(id);
    }
}
