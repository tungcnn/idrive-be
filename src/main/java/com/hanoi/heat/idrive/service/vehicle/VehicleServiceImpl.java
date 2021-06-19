package com.hanoi.heat.idrive.service.vehicle;

import com.hanoi.heat.idrive.model.Location;
import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.model.VehicleType;
import com.hanoi.heat.idrive.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    public Page<Vehicle> findAll(Pageable pageable) {
        return vehicleRepo.findAll(pageable);
    }

    @Override
    public Iterable<Vehicle> findAll() {
        return vehicleRepo.findAll();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicleRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        vehicleRepo.deleteById(id);
    }


    @Override
    public Iterable<Vehicle> findVehicleByLocation(Location location) {
        return vehicleRepo.findVehicleByLocation(location);
    }

    @Override
    public Iterable<Vehicle> findVehicleByVehicleType(VehicleType vehicleType) {
        return vehicleRepo.findVehicleByVehicleType(vehicleType);
    }

    @Override
    public Iterable<Vehicle> findVehicleByLocationAndVehicleType(Location location, VehicleType vehicleType) {
        return vehicleRepo.findVehicleByLocationAndVehicleType(location, vehicleType);
    }
}
