package com.Inventory.MWJ.Model;

public class OrdersVeiw {

	private String printername;
	private String couponCode;
	private String couponType;
	private Long orderquantity;
	private Long totalOrderAmount;

	public OrdersVeiw() {

	}

	public OrdersVeiw(String printername, String couponCode, String couponType, Long orderquantity,
			Long totalOrderAmount)

	{
		this.printername = printername;
		this.couponCode = couponCode;
		this.couponType = couponType;
		this.orderquantity = orderquantity;
		this.totalOrderAmount = totalOrderAmount;
	}

	public String getPrintername() {
		return printername;
	}

	public void setPrintername(String printername) {
		this.printername = printername;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public Long getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(Long orderquantity) {
		this.orderquantity = orderquantity;
	}

	public Long getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(Long totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

}
