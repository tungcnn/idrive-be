package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query(value = "select * from order_detail where start_time = ?1 ", nativeQuery = true)
    Iterable<OrderDetail> findByDate(Date date);
    @Query(value = "select * from order_detail where vehicle_id = ?1 ", nativeQuery = true)
    Iterable<OrderDetail> findByVehicle(Long id);
}
