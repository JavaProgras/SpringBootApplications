package com.Inventory.MWJ.Model;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "supplierdetails")
public class SupplierInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private int supplier_id;

	@Column(name = "printer_name")
	private String printername;

	@Column(name = "coupon_type")
	private String couponType;

	@Column(name = "c_code")
	private String couponCode;

	@Column(name = "supplied_date")
	private Date supplieddate;

	@Column(name = "supplied_qty")
	private Long suppliedqty;

	@Column(name = "due_date")
	private Date dueDate;

	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private OrderDetails order;

	public SupplierInfo() {

	}

	public SupplierInfo(int supplier_id, String printername, String couponType, String couponCode, Date supplieddate,
			Long suppliedqty, Date dueDate, OrderDetails order) {
		super();
		this.supplier_id = supplier_id;
		this.printername = printername;
		this.couponType = couponType;
		this.couponCode = couponCode;
		this.supplieddate = supplieddate;
		this.suppliedqty = suppliedqty;
		this.dueDate = dueDate;
		this.order = order;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
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

	public Date getSupplieddate() {
		return supplieddate;
	}

	public void setSupplieddate(Date supplieddate) {
		this.supplieddate = supplieddate;
	}

	public Long getSuppliedqty() {
		return suppliedqty;
	}

	public void setSuppliedqty(Long suppliedqty) {
		this.suppliedqty = suppliedqty;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

}
