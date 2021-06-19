package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
}
