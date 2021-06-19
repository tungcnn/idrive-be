package com.hanoi.heat.idrive.controller;

import com.hanoi.heat.idrive.model.OrderDetail;
import com.hanoi.heat.idrive.service.OrderDetail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@CrossOrigin("*")
@RequestMapping("/Order")
public class OrderDetailController {

    @Autowired
    private IOrderDetailService detailService;

    @PostMapping("findByDate")
    public ResponseEntity<?> findByVehicle(@RequestBody String date){
        return new ResponseEntity<>(detailService.findByDate(date),HttpStatus.OK);
    }

}
