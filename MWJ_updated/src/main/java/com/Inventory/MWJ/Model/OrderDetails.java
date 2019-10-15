package com.Inventory.MWJ.Model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int order_id;

	private String printername;;
	private String couponType;
	private Long advanceamount;
	private String couponCode;
	private Long orderquantity;
	private Date orderdate;
	private boolean balanceqty;
	private Long amountperpiece;
	private Long totalOrderAmount;
	private Long totalOrderQty;
	private boolean is_paid;

	@OneToMany(targetEntity = SupplierInfo.class, fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private Set<SupplierInfo> listsupplierdetails;

	@OneToMany(targetEntity = PaymentDetails.class, fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private Set<PaymentDetails> listpaymentdetails;

	public OrderDetails() {

	}

	public OrderDetails(String printername, String couponCode, String couponType, Long orderquantity,
			Long totalOrderAmount)

	{
		this.printername = printername;
		this.couponCode = couponCode;
		this.couponType = couponType;
		this.orderquantity = orderquantity;
		this.totalOrderAmount = totalOrderAmount;
	}

	public OrderDetails(String couponCode)

	{
		this.couponCode = couponCode;
	}

	public OrderDetails(int order_id, String printername, String couponType, String couponCode, Long orderquantity,
			Date orderdate, Long amountperpiece, Long totalOrderAmount, Long advanceamount, boolean balanceqty,
			Long totalOrderQty, Set<SupplierInfo> listsupplierdetails, Set<PaymentDetails> listpaymentdetails,
			boolean is_paid) {
		super();
		this.order_id = order_id;
		this.printername = printername;
		this.couponType = couponType;
		this.couponCode = couponCode;
		this.orderquantity = orderquantity;
		this.orderdate = orderdate;
		this.amountperpiece = amountperpiece;
		this.totalOrderAmount = totalOrderAmount;
		this.listsupplierdetails = listsupplierdetails;
		this.listpaymentdetails = listpaymentdetails;
		this.balanceqty = balanceqty;
		this.advanceamount = advanceamount;
		this.totalOrderQty = totalOrderQty;
		this.is_paid = is_paid;

	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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

	public Long getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(Long orderquantity) {
		this.orderquantity = orderquantity;
	}

	public boolean isIs_paid() {
		return is_paid;
	}

	public void setIs_paid(boolean is_paid) {
		this.is_paid = is_paid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Long getAmountperpiece() {
		return amountperpiece;
	}

	public void setAmountperpiece(Long amountperpiece) {
		this.amountperpiece = amountperpiece;
	}

	public Long getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(Long totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public Long getAdvanceamount() {
		return advanceamount;
	}

	public void setAdvanceamount(Long advanceamount) {
		this.advanceamount = advanceamount;
	}

	public boolean getBalanceqty() {
		return balanceqty;
	}

	public void setBalanceqty(boolean balanceqty) {
		this.balanceqty = balanceqty;
	}

	public Long getTotalOrderQty() {
		return totalOrderQty;
	}

	public void setTotalOrderQty(Long totalOrderQty) {
		this.totalOrderQty = totalOrderQty;
	}

	public Set<SupplierInfo> getListsupplierdetails() {
		return listsupplierdetails;
	}

	public void setListsupplierdetails(Set<SupplierInfo> listsupplierdetails) {
		this.listsupplierdetails = listsupplierdetails;
	}

	public Set<PaymentDetails> getListpaymentdetails() {
		return listpaymentdetails;
	}

	public void setListpaymentdetails(Set<PaymentDetails> listpaymentdetails) {
		this.listpaymentdetails = listpaymentdetails;
	}

}
