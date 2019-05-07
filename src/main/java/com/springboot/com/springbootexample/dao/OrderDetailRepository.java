package com.springboot.com.springbootexample.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springboot.com.springbootexample.entity.OrderDetail;

/**
 * 
* <p>Title: OrderDetailRepository</p>  
* <p>Description: PagingAndSortingRepository 集成CrudRepository，提供了附加的分页查询功能</p>  
* @author daihu  
* @date 2019年5月6日
 */
@Repository
public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Integer> {

}
