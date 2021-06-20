package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.User;
import com.hanoi.heat.idrive.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    @Query(value = "select * from vehicle where owner_user_id = ?1 limit 10 offset ?2", nativeQuery = true)
    Iterable<Vehicle> findAllVehicleByOwner(Long id, int offset);
}
