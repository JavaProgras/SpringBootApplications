package com.Inventory.MWJ.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usedcoupons")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UsedCoupons extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usedcoupon_id")
	private Integer usedcoupon_id;

	@Column(name = "used_couponcode")
	private String usedcouponCode;

	@Column(name = "UCC_Code")
	private String ucc_code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "couponcodde_used_date")
	private Date usedcoupon_code_date;

	@Column(name = "customername")
	private String customername;

	@ManyToOne
	@JoinColumn(name = "partner_id")
	@JsonIgnore
	private AddPartner partner;

	public UsedCoupons()
	{
		
	}
	public UsedCoupons(String usedcouponCode) {
		this.usedcouponCode=usedcouponCode;

	}

	public UsedCoupons(Integer usedcoupon_id, String usedcouponCode, String ucc_code, Date usedcoupon_code_date,
			String customername, AddPartner partner) {
		super();
		this.usedcoupon_id = usedcoupon_id;
		this.usedcouponCode = usedcouponCode;
		this.ucc_code = ucc_code;
		this.usedcoupon_code_date = usedcoupon_code_date;
		this.customername = customername;
		this.partner = partner;
	}

	public Integer getUsedcoupon_id() {
		return usedcoupon_id;
	}

	public void setUsedcoupon_id(Integer usedcoupon_id) {
		this.usedcoupon_id = usedcoupon_id;
	}

	public String getUsedcouponCode() {
		return usedcouponCode;
	}

	public void setUsedcouponCode(String usedcouponCode) {
		this.usedcouponCode = usedcouponCode;
	}

	public String getUcc_code() {
		return ucc_code;
	}

	public void setUcc_code(String ucc_code) {
		this.ucc_code = ucc_code;
	}

	public Date getUsedcoupon_code_date() {
		return usedcoupon_code_date;
	}

	public void setUsedcoupon_code_date(Date usedcoupon_code_date) {
		this.usedcoupon_code_date = usedcoupon_code_date;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public AddPartner getPartner() {
		return partner;
	}

	public void setPartner(AddPartner partner) {
		this.partner = partner;
	}

}
