package com.org.onlinetailoring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.onlinetailoring.entity.OrderDetails;
import com.org.onlinetailoring.exception.XasterException;
import com.org.onlinetailoring.repository.OrderDetailsRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderServiceImpl.
 */
@Service
public class OrderServiceImpl implements OrderService {

	/** The order details repository. */
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.onlinetailoring.service.OrderService#getOrderDetails(java.lang.
	 * Integer)
	 */
	public OrderDetails getOrderDetails(Integer orderId) throws XasterException {
		Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderId);
		if (orderDetails.isPresent()) {
			return orderDetails.get();
		} else {
			throw new XasterException("invalid Order Details");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.onlinetailoring.service.OrderService#createOrder(com.org.
	 * onlinetailoring.entity.OrderDetails)
	 */
	@Override
	public OrderDetails createOrder(OrderDetails orderDetails) {
		OrderDetails resultOrderDetails = orderDetailsRepository.save(orderDetails);
		return resultOrderDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.onlinetailoring.service.OrderService#getOrderDetailsByUserId(java.
	 * lang.Integer)
	 */
	@Override
	public List<OrderDetails> getOrderDetailsByUserId(Integer id) {
		return orderDetailsRepository.getOrderDetailsByUserId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.onlinetailoring.service.OrderService#getAllOrders()
	 */
	@Override
	public List<OrderDetails> getAllOrders() {
		return orderDetailsRepository.findAll();
	}

}
