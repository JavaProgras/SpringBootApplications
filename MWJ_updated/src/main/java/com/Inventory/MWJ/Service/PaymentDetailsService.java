package com.Inventory.MWJ.Service;

import com.Inventory.MWJ.Model.PaymentDetails;

public interface PaymentDetailsService {

	public PaymentDetails savepaymentdetails(Integer order_id,PaymentDetails paymentdetaails);

	public PaymentDetails updatepaymentdetails(PaymentDetails paymentdetaails);

}
