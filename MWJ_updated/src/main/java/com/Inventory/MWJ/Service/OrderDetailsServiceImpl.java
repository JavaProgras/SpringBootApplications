package com.Inventory.MWJ.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.MWJ.Model.OrderDetails;
import com.Inventory.MWJ.Repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderrepo;

	@Override
	public OrderDetails saveOrderDetails(OrderDetails orderdetails) {

		Long totalOrderamount = orderdetails.getOrderquantity() * orderdetails.getAmountperpiece();

		orderdetails.setTotalOrderAmount(totalOrderamount);
		List<OrderDetails> olist = orderrepo.findAll();
		Long totalorderqty = (long) 0 + orderdetails.getOrderquantity();

		for (OrderDetails order : olist) {
			if (order.getCouponCode().equalsIgnoreCase(orderdetails.getCouponCode())
					& order.getCouponType().equalsIgnoreCase(orderdetails.getCouponType())) {
				totalorderqty += order.getTotalOrderQty();
			}

		}
		orderdetails.setTotalOrderQty(totalorderqty);
		return orderrepo.save(orderdetails);
	}

	@Override
	public OrderDetails updateOrderDetails(OrderDetails orderdeatils) {
		return orderrepo.save(orderdeatils);
	}

	@Override
	public List<OrderDetails> getOrderslist() {

		return orderrepo.findAll();

	}

	@Override
	public List<OrderDetails> getordersVeiw() {

		return orderrepo.getAllSelectedDetails();
	}

}
