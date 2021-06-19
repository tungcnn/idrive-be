package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {
}
