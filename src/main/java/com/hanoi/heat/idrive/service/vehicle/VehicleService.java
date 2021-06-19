package com.hanoi.heat.idrive.service.vehicle;

import com.hanoi.heat.idrive.model.Vehicle;
import com.hanoi.heat.idrive.service.IGeneralService;

public interface VehicleService extends IGeneralService<Vehicle> {
    Iterable<Vehicle> findVehiclesByLocationName(String locationName);
    Iterable<Vehicle> findVehicleByVehicleTypeName(String vehicleTypeName);
    Iterable<Vehicle> findVehicleByLocationNameAndVehicleTypeName(String locationName, String vehicleTypeName);
}
