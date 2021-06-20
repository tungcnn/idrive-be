package com.hanoi.heat.idrive.service.vehicle;

import com.hanoi.heat.idrive.model.User;
import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService extends IGeneralService<Vehicle> {
    Iterable<Vehicle> findAllByOwner(Long id, int pageNo);
}
