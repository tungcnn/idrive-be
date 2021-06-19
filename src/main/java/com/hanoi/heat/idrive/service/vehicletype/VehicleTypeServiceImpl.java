package com.hanoi.heat.idrive.service.vehicletype;

import com.hanoi.heat.idrive.model.VehicleType;
import com.hanoi.heat.idrive.repository.VehicleTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService{
    @Autowired
    private VehicleTypeRepo vehicleTypeRepo;

    @Override
    public Page<VehicleType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<VehicleType> findAll() {
        return vehicleTypeRepo.findAll();
    }

    @Override
    public VehicleType save(VehicleType vehicleType) {
        return null;
    }

    @Override
    public Optional<VehicleType> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
