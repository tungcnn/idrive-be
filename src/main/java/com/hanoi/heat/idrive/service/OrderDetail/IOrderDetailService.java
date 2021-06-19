package com.hanoi.heat.idrive.service.OrderDetail;

import com.hanoi.heat.idrive.model.OrderDetail;
import com.hanoi.heat.idrive.service.IGeneralService;

import java.sql.Timestamp;
import java.util.Date;

public interface IOrderDetailService extends IGeneralService<OrderDetail> {
    Iterable<OrderDetail> findByDate(String date);
}
