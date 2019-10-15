package com.Inventory.MWJ.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Model.PaymentDetails;

import com.Inventory.MWJ.Service.PaymentDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/paymentinfo")
public class PaymentController {

	@Autowired
	private PaymentDetailsService paymentservice;

	@PostMapping("/save/{order_id}")
	public PaymentDetails savepaymentDetails(@PathVariable(value = "order_id") Integer order_id,
			@RequestBody PaymentDetails paymentdetails) {

		return paymentservice.savepaymentdetails(order_id, paymentdetails);

	}

	@PutMapping("/update")
	public ResponseEntity<PaymentDetails> upatepaymentDetails(@RequestBody PaymentDetails paymentdetails) {
		PaymentDetails payment = paymentservice.updatepaymentdetails(paymentdetails);
		return new ResponseEntity<PaymentDetails>(payment, HttpStatus.OK);
	}

}
