package com.hanoi.heat.idrive.service.OrderDetail;

import com.hanoi.heat.idrive.model.OrderDetail;
import com.hanoi.heat.idrive.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderDetailServiceService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository detailRepository;

    @Override
    public Page<OrderDetail> findAll(Pageable pageable) {
        return detailRepository.findAll(pageable);
    }

    @Override
    public Iterable<OrderDetail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return detailRepository.save(orderDetail);
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        detailRepository.deleteById(id);
    }


    @Override
    public Iterable<OrderDetail> findByDate(String Date) {
        String date = "%"+Date+"%";
        return detailRepository.findByDate(date);
    }
}
