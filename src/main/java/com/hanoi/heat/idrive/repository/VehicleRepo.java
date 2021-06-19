package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.Location;
import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    Iterable<Vehicle> findVehicleByLocation(Location location);
    Iterable<Vehicle> findVehicleByVehicleType(VehicleType vehicleType);
    Iterable<Vehicle> findVehicleByLocationAndVehicleType(Location location, VehicleType vehicleType);
}
