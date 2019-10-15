package com.Inventory.MWJ.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PrinterInfo")
public class PrinterInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partner_id")
	private int printer_id;

	@Column(name = "printername")
	private String Printername;

	@Column(name = "contactno")
	private Long contactno;

	@Column(name = "officeno")
	private Long officeno;

	@Column(name = "address")
	private String address;

	@Column(name = "email_id")
	private String emailid;

	@Column(name = "account_no")
	private Long acc_no;

	@Column(name = "ifsc_code")
	private String ifsc_code;

	@Column(name = "gstin_no")
	private String gstin_no;

	@Column(name = "account_holder_name")
	private String account_holder_name;

	public PrinterInfo() {

	}

	public PrinterInfo(int printer_id, String printername, Long contactno, Long officeno, String address,
			String emailid, Long acc_no, String ifsc_code, String gstin_no, String account_holder_name) {
		super();
		this.printer_id = printer_id;
		Printername = printername;
		this.contactno = contactno;
		this.officeno = officeno;
		this.address = address;
		this.emailid = emailid;
		this.acc_no = acc_no;
		this.ifsc_code = ifsc_code;
		this.gstin_no = gstin_no;
		this.account_holder_name = account_holder_name;
	}

	public int getPrinter_id() {
		return printer_id;
	}

	public void setPrinter_id(int printer_id) {
		this.printer_id = printer_id;
	}

	public String getPrintername() {
		return Printername;
	}

	public void setPrintername(String printername) {
		Printername = printername;
	}

	public Long getContactno() {
		return contactno;
	}

	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}

	public Long getOfficeno() {
		return officeno;
	}

	public void setOfficeno(Long officeno) {
		this.officeno = officeno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(Long acc_no) {
		this.acc_no = acc_no;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getGstin_no() {
		return gstin_no;
	}

	public void setGstin_no(String gstin_no) {
		this.gstin_no = gstin_no;
	}

	public String getAccount_holder_name() {
		return account_holder_name;
	}

	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}

}
