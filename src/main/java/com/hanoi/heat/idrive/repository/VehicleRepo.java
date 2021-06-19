package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    Iterable<Vehicle> findVehiclesByLocationName(String locationName);
    Iterable<Vehicle> findVehicleByVehicleTypeName(String vehicleTypeName);
    Iterable<Vehicle> findVehicleByLocationNameAndVehicleTypeName(String locationName, String vehicleTypeName);
}
