package com.hanoi.heat.idrive.service.OrderDetail;

import com.hanoi.heat.idrive.model.OrderDetail;
import com.hanoi.heat.idrive.service.IGeneralService;

import java.util.Date;

public interface IOrderDetailService extends IGeneralService<OrderDetail> {
    Iterable<OrderDetail> findByVehicle(Long id);
    Iterable<OrderDetail> findByDate(Date date);
}
