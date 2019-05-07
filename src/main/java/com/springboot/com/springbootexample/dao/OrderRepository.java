package com.springboot.com.springbootexample.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.com.springbootexample.entity.Order;

/**
 * 
* <p>Title: OrderRepository</p>  
* <p>Description:CRUDRepository的使用 提供了基本的增删改查，批量操作接口</p>  
* @author daihu  
* @date 2019年5月6日
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>  {
}
