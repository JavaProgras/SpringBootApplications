package com.Inventory.MWJ.Service;

import java.util.List;

import com.Inventory.MWJ.Model.OrderDetails;

public interface OrderDetailsService {

	public OrderDetails saveOrderDetails(OrderDetails orderdeatils);

	public OrderDetails updateOrderDetails(OrderDetails orderdeatils);

	public List<OrderDetails> getOrderslist();

	public List<OrderDetails> getordersVeiw();

}
