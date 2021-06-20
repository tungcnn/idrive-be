package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.Image;
import com.hanoi.heat.idrive.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ImageRepo extends JpaRepository<Image, Long> {
    @Query(value = "select * from image where vehicle_id=?1", nativeQuery = true)
    Iterable<Image> findAllByVehicle(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from image where vehicle_id=?1", nativeQuery = true)
    void deletePhotoOfVehicle(Long id);
}
