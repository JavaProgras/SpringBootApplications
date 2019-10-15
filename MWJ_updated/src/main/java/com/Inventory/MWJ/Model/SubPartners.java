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
@Table(name = "subpartners")
public class SubPartners extends AuditModel {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sub_id;
	@Column(name = "company_name")
	private String company_name_input;

	@Column(name = "master_company_name")
	private String mastercompany_name;

	@Column(name = "person_name")
	private String personname;

	@Column(name = "email")
	private String email;

	@Column(name = "contact_number")
	private String contactno;

	@Column(name = "street")
	private String street;

	@Column(name = "city_name")
	private String city;

	@Column(name = "state_name")
	private String state;

	@Column(name = "pin_code")
	private Integer pincode;

	@Column(name = "account_number")
	private long accountno;

	@Column(name = "account_holdername")
	private String account_holdername;

	@Column(name = "ifsc_code")
	private String ifscCode;

	@Column(name = "gtin_no")
	private String gstinNo;

	@Column(name = "coupon_code")
	private String coupon_code;

	@Column(name = "no_of_couponsprovided")
	private Integer no_of_couponsProvided;

	@Column(name = "coup_provided_date")
	private Date coupon_provided_date;

	@Column(name = "payment_amount")
	private Integer payment_amount;

	@Column(name = "payment_date")
	private Date payment_date;

	@Column(name = "company_type")
	private String company_type;

	@ManyToOne
	@JoinColumn(name = "partner_id")
	@JsonIgnore
	private AddPartner partner;

	public SubPartners() {

	}

	public SubPartners(int sub_id, String company_name_input, String mastercompany_name, String personname,
			String email, String contactno, String street, String city, String state, Integer pincode, long accountno,
			String account_holdername, String ifscCode, String gstinNo, String coupon_code,
			Integer no_of_couponsProvided, Date coupon_provided_date, Integer payment_amount, Date payment_date,
			String company_type, AddPartner partner) {
		super();
		this.sub_id = sub_id;
		this.company_name_input = company_name_input;
		this.mastercompany_name = mastercompany_name;
		this.personname = personname;
		this.email = email;
		this.contactno = contactno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.accountno = accountno;
		this.account_holdername = account_holdername;
		this.ifscCode = ifscCode;
		this.gstinNo = gstinNo;
		this.coupon_code = coupon_code;
		this.no_of_couponsProvided = no_of_couponsProvided;
		this.coupon_provided_date = coupon_provided_date;
		this.payment_amount = payment_amount;
		this.payment_date = payment_date;
		this.company_type = company_type;
		this.partner = partner;
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getCompany_name_input() {
		return company_name_input;
	}

	public void setCompany_name_input(String company_name_input) {
		this.company_name_input = company_name_input;
	}

	public String getMastercompany_name() {
		return mastercompany_name;
	}

	public void setMastercompany_name(String mastercompany_name) {
		this.mastercompany_name = mastercompany_name;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public String getAccount_holdername() {
		return account_holdername;
	}

	public void setAccount_holdername(String account_holdername) {
		this.account_holdername = account_holdername;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getGstinNo() {
		return gstinNo;
	}

	public void setGstinNo(String gstinNo) {
		this.gstinNo = gstinNo;
	}

	public String getCoupon_code() {
		return coupon_code;
	}

	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}

	public Integer getNo_of_couponsProvided() {
		return no_of_couponsProvided;
	}

	public void setNo_of_couponsProvided(Integer no_of_couponsProvided) {
		this.no_of_couponsProvided = no_of_couponsProvided;
	}

	public Date getCoupon_provided_date() {
		return coupon_provided_date;
	}

	public void setCoupon_provided_date(Date coupon_provided_date) {
		this.coupon_provided_date = coupon_provided_date;
	}

	public Integer getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(Integer payment_amount) {
		this.payment_amount = payment_amount;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public String getCompany_type() {
		return company_type;
	}

	public void setCompany_type(String company_type) {
		this.company_type = company_type;
	}

	public AddPartner getPartner() {
		return partner;
	}

	public void setPartner(AddPartner partner) {
		this.partner = partner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
