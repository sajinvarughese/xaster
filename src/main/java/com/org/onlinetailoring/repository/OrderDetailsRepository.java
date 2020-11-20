package com.org.onlinetailoring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.onlinetailoring.entity.OrderDetails;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrderDetailsRepository.
 */
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

	/**
	 * Gets the order details by user id.
	 *
	 * @param id the id
	 * @return the order details by user id
	 */
	@Query(nativeQuery = true, value ="select * from order_details where user_id = :userId" )
	List<OrderDetails> getOrderDetailsByUserId(@Param("userId") Integer id);

}
