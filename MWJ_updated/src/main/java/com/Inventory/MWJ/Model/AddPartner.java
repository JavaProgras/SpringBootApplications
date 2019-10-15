package com.Inventory.MWJ.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "addpartner")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AddPartner extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partner_id")
	private Integer partner_id;

	@Column(name = "company_name")
	private String company_name_input;

	@Column(name = "person_name")
	private String person_name_input;

	@Column(name = "email")
	private String person_email_input;

	@Column(name = "contact_number")
	private String person_contactno_input;

	@Column(name = "street")
	private String address_street_input;

	@Column(name = "city_name")
	private String address_city_input;

	@Column(name = "state_name")
	private String address_state_input;

	@Column(name = "pin_code")
	private Integer address_pincode_input;

	@Column(name = "account_number")
	private long bank_acno_input;

	@Column(name = "account_holdername")
	private String bank_acname_input;

	@Column(name = "ifsc_code")
	private String bank_ifsc_input;

	@Column(name = "gtin_no")
	private String bank_gstin_input;

	@Column(name = "coupon_code")
	private String coupon_code_input;

	@Column(name = "no_of_couponsprovided")
	private Integer coupon_provided_num_input;

	@Column(name = "coup_provided_date")
	private Date coupon_provided_date_input;

	@Column(name = "payment_amount")
	private Integer payment_amount_input;

	@Column(name = "payment_date")
	private Date payment_date_input;

	@Column(name = "company_type")
	private String company_type_input;

	@Column(name = "total_no_of_coupons_distributed")
	private Integer dcoupon_distributed_count;

	@Column(name = "total_no_of_coupons_Used")
	private Integer used_coupon_count;

	@OneToMany(targetEntity = DistributedCoupons.class, fetch = FetchType.LAZY, mappedBy = "partner", cascade = CascadeType.ALL)
	private Set<DistributedCoupons> listdistCoupons;

	@OneToMany(targetEntity = UsedCoupons.class, fetch = FetchType.LAZY, mappedBy = "partner", cascade = CascadeType.ALL)
	private Set<UsedCoupons> listusedcoupins;

	@OneToMany(targetEntity = MoreProvidedCoupons.class, fetch = FetchType.LAZY, mappedBy = "partner", cascade = CascadeType.ALL)
	private Set<MoreProvidedCoupons> listprovidedcoupins;

	@OneToMany(targetEntity = SubPartners.class, fetch = FetchType.LAZY, mappedBy = "partner", cascade = CascadeType.ALL)
	private Set<SubPartners> listSubPartners;

	public AddPartner() {

	}

	public AddPartner(Integer partner_id, String company_name_input, String person_name_input,
			String person_email_input, String person_contactno_input, String address_street_input,
			String address_city_input, String address_state_input, Integer address_pincode_input, long bank_acno_input,
			String bank_acname_input, String bank_ifsc_input, String bank_gstin_input, String coupon_code_input,
			Integer coupon_provided_num_input, Date coupon_provided_date_input, Integer payment_amount_input,
			Date payment_date_input, String company_type_input, Integer dcoupon_distributed_count,
			Integer used_coupon_count, Set<DistributedCoupons> listdistCoupons, Set<UsedCoupons> listusedcoupins,
			Set<MoreProvidedCoupons> listprovidedcoupins, Set<SubPartners> listSubPartners) {
		super();
		this.partner_id = partner_id;
		this.company_name_input = company_name_input;
		this.person_name_input = person_name_input;
		this.person_email_input = person_email_input;
		this.person_contactno_input = person_contactno_input;
		this.address_street_input = address_street_input;
		this.address_city_input = address_city_input;
		this.address_state_input = address_state_input;
		this.address_pincode_input = address_pincode_input;
		this.bank_acno_input = bank_acno_input;
		this.bank_acname_input = bank_acname_input;
		this.bank_ifsc_input = bank_ifsc_input;
		this.bank_gstin_input = bank_gstin_input;
		this.coupon_code_input = coupon_code_input;
		this.coupon_provided_num_input = coupon_provided_num_input;
		this.coupon_provided_date_input = coupon_provided_date_input;
		this.payment_amount_input = payment_amount_input;
		this.payment_date_input = payment_date_input;
		this.company_type_input = company_type_input;
		this.dcoupon_distributed_count = dcoupon_distributed_count;
		this.used_coupon_count = used_coupon_count;
		this.listdistCoupons = listdistCoupons;
		this.listusedcoupins = listusedcoupins;
		this.listprovidedcoupins = listprovidedcoupins;
		this.listSubPartners = listSubPartners;
	}

	public Integer getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(Integer partner_id) {
		this.partner_id = partner_id;
	}

	public String getCompany_name_input() {
		return company_name_input;
	}

	public void setCompany_name_input(String company_name_input) {
		this.company_name_input = company_name_input;
	}

	public String getPerson_name_input() {
		return person_name_input;
	}

	public void setPerson_name_input(String person_name_input) {
		this.person_name_input = person_name_input;
	}

	public String getPerson_email_input() {
		return person_email_input;
	}

	public void setPerson_email_input(String person_email_input) {
		this.person_email_input = person_email_input;
	}

	public String getPerson_contactno_input() {
		return person_contactno_input;
	}

	public void setPerson_contactno_input(String person_contactno_input) {
		this.person_contactno_input = person_contactno_input;
	}

	public String getAddress_street_input() {
		return address_street_input;
	}

	public void setAddress_street_input(String address_street_input) {
		this.address_street_input = address_street_input;
	}

	public String getAddress_city_input() {
		return address_city_input;
	}

	public void setAddress_city_input(String address_city_input) {
		this.address_city_input = address_city_input;
	}

	public String getAddress_state_input() {
		return address_state_input;
	}

	public void setAddress_state_input(String address_state_input) {
		this.address_state_input = address_state_input;
	}

	public Integer getAddress_pincode_input() {
		return address_pincode_input;
	}

	public void setAddress_pincode_input(Integer address_pincode_input) {
		this.address_pincode_input = address_pincode_input;
	}

	public long getBank_acno_input() {
		return bank_acno_input;
	}

	public void setBank_acno_input(long bank_acno_input) {
		this.bank_acno_input = bank_acno_input;
	}

	public String getBank_acname_input() {
		return bank_acname_input;
	}

	public void setBank_acname_input(String bank_acname_input) {
		this.bank_acname_input = bank_acname_input;
	}

	public String getBank_ifsc_input() {
		return bank_ifsc_input;
	}

	public void setBank_ifsc_input(String bank_ifsc_input) {
		this.bank_ifsc_input = bank_ifsc_input;
	}

	public String getBank_gstin_input() {
		return bank_gstin_input;
	}

	public void setBank_gstin_input(String bank_gstin_input) {
		this.bank_gstin_input = bank_gstin_input;
	}

	public String getCoupon_code_input() {
		return coupon_code_input;
	}

	public void setCoupon_code_input(String coupon_code_input) {
		this.coupon_code_input = coupon_code_input;
	}

	public Integer getCoupon_provided_num_input() {
		return coupon_provided_num_input;
	}

	public void setCoupon_provided_num_input(Integer coupon_provided_num_input) {
		this.coupon_provided_num_input = coupon_provided_num_input;
	}

	public Date getCoupon_provided_date_input() {
		return coupon_provided_date_input;
	}

	public void setCoupon_provided_date_input(Date coupon_provided_date_input) {
		this.coupon_provided_date_input = coupon_provided_date_input;
	}

	public Integer getPayment_amount_input() {
		return payment_amount_input;
	}

	public void setPayment_amount_input(Integer payment_amount_input) {
		this.payment_amount_input = payment_amount_input;
	}

	public Date getPayment_date_input() {
		return payment_date_input;
	}

	public void setPayment_date_input(Date payment_date_input) {
		this.payment_date_input = payment_date_input;
	}

	public String getCompany_type_input() {
		return company_type_input;
	}

	public void setCompany_type_input(String company_type_input) {
		this.company_type_input = company_type_input;
	}

	public Integer getDcoupon_distributed_count() {
		return dcoupon_distributed_count;
	}

	public void setDcoupon_distributed_count(Integer dcoupon_distributed_count) {
		this.dcoupon_distributed_count = dcoupon_distributed_count;
	}

	public Integer getUsed_coupon_count() {
		return used_coupon_count;
	}

	public void setUsed_coupon_count(Integer used_coupon_count) {
		this.used_coupon_count = used_coupon_count;
	}

	public Set<DistributedCoupons> getListdistCoupons() {
		return listdistCoupons;
	}

	public void setListdistCoupons(Set<DistributedCoupons> listdistCoupons) {
		this.listdistCoupons = listdistCoupons;
	}

	public Set<UsedCoupons> getListusedcoupins() {
		return listusedcoupins;
	}

	public void setListusedcoupins(Set<UsedCoupons> listusedcoupins) {
		this.listusedcoupins = listusedcoupins;
	}

	public Set<MoreProvidedCoupons> getListprovidedcoupins() {
		return listprovidedcoupins;
	}

	public void setListprovidedcoupins(Set<MoreProvidedCoupons> listprovidedcoupins) {
		this.listprovidedcoupins = listprovidedcoupins;
	}

	public Set<SubPartners> getListSubPartners() {
		return listSubPartners;
	}

	public void setListSubPartners(Set<SubPartners> listSubPartners) {
		this.listSubPartners = listSubPartners;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
