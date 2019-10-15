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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "distributedcoupon")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DistributedCoupons extends AuditModel {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dist_id")
	private Integer dist_id;

	@Column(name = "no_of_coupons_distributed")
	private Integer couponsdistributed;

	@Column(name = "distributed_date")
	private Date distributeddate;

	@Column(name = "company_name")
	private String companyname;

	@Column(name = "coupon_code")
	private String couponcode;

	@ManyToOne
	@JoinColumn(name = "partner_id")
	@JsonIgnore
	private AddPartner partner;

	public Integer getDist_id() {
		return dist_id;
	}

	public void setDist_id(Integer dist_id) {
		this.dist_id = dist_id;
	}

	/*
	 * public Set<UsedCoupons> getListusedcoupins() { return listusedcoupins; }
	 * 
	 * public void setListusedcoupins(Set<UsedCoupons> listusedcoupins) {
	 * this.listusedcoupins = listusedcoupins; }
	 */

	public DistributedCoupons() {

	}

	public DistributedCoupons(Integer id, Integer couponsdistributed, Date distributeddate, String companyname,
			String couponcode, AddPartner partner) {
		super();
		this.dist_id = id;
		this.couponsdistributed = couponsdistributed;
		this.distributeddate = distributeddate;
		this.companyname = companyname;
		this.couponcode = couponcode;
		this.partner = partner;

	}

	public Integer getId() {
		return dist_id;
	}

	public void setId(Integer id) {
		this.dist_id = id;
	}

	public Integer getCouponsdistributed() {
		return couponsdistributed;
	}

	public void setCouponsdistributed(Integer couponsdistributed) {
		this.couponsdistributed = couponsdistributed;
	}

	public Date getDistributeddate() {
		return distributeddate;
	}

	public void setDistributeddate(Date distributeddate) {
		this.distributeddate = distributeddate;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCouponcode() {
		return couponcode;
	}

	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}

	public AddPartner getPartner() {
		return partner;
	}

	public void setPartner(AddPartner partner) {
		this.partner = partner;
	}

}
