package com.org.onlinetailoring.service;

import java.util.List;

import com.org.onlinetailoring.entity.OrderDetails;
import com.org.onlinetailoring.exception.XasterException;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrderService.
 */
public interface OrderService {

	/**
	 * Gets the order details.
	 *
	 * @param OrderId            the order id
	 * @return the order details
	 * @throws XasterException the xaster exception
	 */
	public OrderDetails getOrderDetails(Integer OrderId) throws XasterException;

	/**
	 * Creates the order.
	 *
	 * @param orderDetails
	 *            the order details
	 * @return the order details
	 */
	public OrderDetails createOrder(OrderDetails orderDetails);

	/**
	 * Gets the order details by user id.
	 *
	 * @param id
	 *            the id
	 * @return the order details by user id
	 */
	public List<OrderDetails> getOrderDetailsByUserId(Integer id);

	/**
	 * Gets the all orders.
	 *
	 * @return the all orders
	 */
	public List<OrderDetails> getAllOrders();

}
