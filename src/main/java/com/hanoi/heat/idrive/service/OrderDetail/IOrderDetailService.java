package com.hanoi.heat.idrive.service.OrderDetail;

import com.hanoi.heat.idrive.model.OrderDetail;
import com.hanoi.heat.idrive.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IOrderDetailService extends IGeneralService<OrderDetail> {
    Iterable<OrderDetail> findByDate(String date);
    List<OrderDetail> History(Long id);
}
