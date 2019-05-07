package com.springboot.com.springbootexample.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.com.springbootexample.dao.OrderRepository;
import com.springboot.com.springbootexample.entity.Order;
import com.springboot.com.springbootexample.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderRepository orderServiceImpl;
	@Override
	public void save(Order order) {
		orderServiceImpl.save(order);
	}
}
