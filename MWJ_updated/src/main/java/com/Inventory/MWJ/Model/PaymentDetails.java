package com.Inventory.MWJ.Model;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "paymentdetails")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int payment_id;
	@Column(name = "printer_name")
	private String printername;
	@Column(name = "coupon_type")
	private String couponType;

	@Column(name = "coupon_code")
	private String couponCode;
	@Column(name = "amount_paid")
	private Long amountpaid;
	@Column(name = "total_amount")
	private Long totalAmount;
	@Column(name = "due_amount")
	private Long dueAmount;
	@Column(name = "payment_date")
	private Date paymentDate;

	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private OrderDetails order;

	public PaymentDetails() {

	}

	public PaymentDetails(int payment_id, String printername, String couponType, String couponCode, Long amountpaid,
			Long totalAmount, Long dueAmount, Date paymentDate, OrderDetails order) {
		super();
		this.payment_id = payment_id;
		this.printername = printername;
		this.couponType = couponType;
		this.couponCode = couponCode;
		this.amountpaid = amountpaid;
		this.totalAmount = totalAmount;
		this.dueAmount = dueAmount;
		this.paymentDate = paymentDate;
		this.order = order;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPrintername() {
		return printername;
	}

	public void setPrintername(String printername) {
		this.printername = printername;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Long getAmountpaid() {
		return amountpaid;
	}

	public Long setAmountpaid(Long amountpaid) {
		return this.amountpaid = amountpaid;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public Long setTotalAmount(Long totalAmount) {
		return this.totalAmount = totalAmount;
	}

	public Long getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Long dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

}
