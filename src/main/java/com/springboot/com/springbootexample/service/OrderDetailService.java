package com.springboot.com.springbootexample.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.com.springbootexample.entity.OrderDetail;

public interface OrderDetailService {

	
	void save(OrderDetail orderDetail);
	Page<OrderDetail> findAll(Pageable pageable);
}
