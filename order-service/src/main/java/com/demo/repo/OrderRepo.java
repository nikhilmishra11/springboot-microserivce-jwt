/**
 * 
 */
package com.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Order;

/**
 * @author nikhi
 *
 */
public interface OrderRepo extends CrudRepository<Order, Long> {

	List<Order> findByStatus(String string);

}
