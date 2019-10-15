package com.Inventory.MWJ.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Inventory.MWJ.Exceptions.ResourceNotFoundException;
import com.Inventory.MWJ.Model.OrderDetails;
import com.Inventory.MWJ.Model.PaymentDetails;
import com.Inventory.MWJ.Repository.OrderDetailsRepository;
import com.Inventory.MWJ.Repository.PaymentDetailsRepository;

@Service
public class PaymentDetailsInfoServiceImpl implements PaymentDetailsService {

	@Autowired
	private PaymentDetailsRepository paymentrepo;

	@Autowired
	private OrderDetailsRepository orderrepo;

	@Override
	public PaymentDetails savepaymentdetails(@PathVariable(value = "order_id") Integer order_id,
			PaymentDetails paymentdetails) {

		return orderrepo.findById(order_id).map(order -> {
			paymentdetails.setOrder(order);
			List<OrderDetails> olist = orderrepo.findAll();
			Long totalOrderamt = orderrepo.getTotalOrderAmount(paymentdetails.getCouponCode(),
					paymentdetails.getCouponType());
			Long totalAmountPaid = paymentdetails.getAmountpaid()
					+ paymentrepo.getTotalOrderAmount(paymentdetails.getCouponCode(), paymentdetails.getCouponType());
			paymentdetails.setTotalAmount(totalOrderamt);
			Long dueamount = totalOrderamt - totalAmountPaid;
			paymentdetails.setDueAmount(dueamount);
			for (OrderDetails orders : olist) {
				if (dueamount == 0) {
					orders.setIs_paid(true);
					
				}
			}
			System.out.println(dueamount);
			return paymentrepo.save(paymentdetails);

		}).orElseThrow(() -> new ResourceNotFoundException("order_id" + order_id + "notfound"));

	}

	@Override
	public PaymentDetails updatepaymentdetails(PaymentDetails paymentdetaails) {
		return paymentrepo.save(paymentdetaails);

	}
}
