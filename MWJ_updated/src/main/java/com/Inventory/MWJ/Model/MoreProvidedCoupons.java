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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="providedcoupons")
public class MoreProvidedCoupons {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="provided_couponsid")
	private int providedcouponsid;
	
	@Column(name="company_name")
	private String companyname;
	
	@Column(name="coupon_code")
	private String coupon_code;
	
	@Column(name="coupons_count")
	private Integer couponscount;
	
	@Column(name="coupons_provided_date")
	private Date couponsprovideddate;
	
	@ManyToOne
	@JoinColumn(name = "partner_id")
	@JsonIgnore
	private AddPartner partner;
	
	public MoreProvidedCoupons()
	{
		
	}

	public MoreProvidedCoupons(int providedcouponsid, String companyname, String coupon_code, Integer couponscount,
			Date couponsprovideddate, AddPartner partner) {
		super();
		this.providedcouponsid = providedcouponsid;
		this.companyname = companyname;
		this.coupon_code = coupon_code;
		this.couponscount = couponscount;
		this.couponsprovideddate = couponsprovideddate;
		this.partner = partner;
	}

	public int getProvidedcouponsid() {
		return providedcouponsid;
	}

	public void setProvidedcouponsid(int providedcouponsid) {
		this.providedcouponsid = providedcouponsid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCoupon_code() {
		return coupon_code;
	}

	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}

	public Integer getCouponscount() {
		return couponscount;
	}

	public long setCouponscount(Integer couponscount) {
		return this.couponscount = couponscount;
	}

	public Date getCouponsprovideddate() {
		return couponsprovideddate;
	}

	public void setCouponsprovideddate(Date couponsprovideddate) {
		this.couponsprovideddate = couponsprovideddate;
	}

	public AddPartner getPartner() {
		return partner;
	}

	public void setPartner(AddPartner partner) {
		this.partner = partner;
	}


	
	
}
