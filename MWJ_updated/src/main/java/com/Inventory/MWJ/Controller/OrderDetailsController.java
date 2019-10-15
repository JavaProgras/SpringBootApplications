package com.Inventory.MWJ.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Inventory.MWJ.Model.OrderDetails;

import com.Inventory.MWJ.Service.OrderDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderservice;

	@PostMapping("/save")
	public ResponseEntity<OrderDetails> saveorderDetails(@RequestBody OrderDetails orderdetails) {

		OrderDetails order = orderservice.saveOrderDetails(orderdetails);

		return new ResponseEntity<OrderDetails>(order, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<OrderDetails> updateorderDetails(@RequestBody OrderDetails orderdetails) {
		OrderDetails order = orderservice.updateOrderDetails(orderdetails);

		return new ResponseEntity<OrderDetails>(order, HttpStatus.OK);
	}

	@GetMapping("/getorderslist")
	public List<OrderDetails> getoderderList() {
		return orderservice.getOrderslist();
	}

	@GetMapping("/veiworder")
	public List<OrderDetails> getSelectedOrdersVeiw() {

		return orderservice.getordersVeiw();

	}

}
