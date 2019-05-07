package com.springboot.com.springbootexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.com.springbootexample.entity.OrderDetail;

public interface OrderDetailJspRepository extends JpaRepository<OrderDetail, Integer> {

}
