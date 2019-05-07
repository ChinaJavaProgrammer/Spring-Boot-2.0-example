package com.springboot.com.springbootexample.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.com.springbootexample.dao.OrderDetailRepository;
import com.springboot.com.springbootexample.entity.OrderDetail;
import com.springboot.com.springbootexample.service.OrderDetailService;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailServiceImpl;
	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailServiceImpl.save(orderDetail);
	}
	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		
		return orderDetailServiceImpl.findAll(pageable);
	}
}
