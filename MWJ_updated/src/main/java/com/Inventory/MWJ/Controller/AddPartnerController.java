package com.Inventory.MWJ.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.Inventory.MWJ.Exceptions.ResourceNotFoundException;
import com.Inventory.MWJ.Model.AddPartner;
import com.Inventory.MWJ.Model.DistributedCoupons;
import com.Inventory.MWJ.Model.MoreProvidedCoupons;
import com.Inventory.MWJ.Model.UsedCoupons;
import com.Inventory.MWJ.Repository.AddPartnerRepository;
import com.Inventory.MWJ.Repository.UsedCouponsCRepository;
//import com.Inventory.MWJ.Repository.AddPartnerRepository;
import com.Inventory.MWJ.Service.AddPartnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AddPartnerController {

	@Autowired
	private AddPartnerService addPartnerService;

	@Autowired
	private AddPartnerRepository partnerrepo;
	@Autowired
	private UsedCouponsCRepository usedrepo;

	@PostMapping("/save")
	public ResponseEntity<AddPartner> savePartner(@RequestBody AddPartner addPartner) {

		AddPartner partner = addPartnerService.savePartrner(addPartner);
		return new ResponseEntity<AddPartner>(partner, HttpStatus.OK);
	}

	/*
	 * @DeleteMapping("/delete/{id}") public ResponseEntity<String>
	 * deletePartner(@PathVariable(value = "id") Integer id) {
	 * addPartnerService.deletePartner(id); return new
	 * ResponseEntity<String>("deleted Successfully " + id, HttpStatus.OK); }
	 */

	@GetMapping("/getpartners")
	public ResponseEntity<List<AddPartner>> getAllUser() {

		List<AddPartner> plist = partnerrepo.findAll();
		for (AddPartner partner : plist) {
			int totalProvinideCount = 0;
			int totaldistcount = 0;
			int ucoupons = 0;
			totalProvinideCount += partner.getCoupon_provided_num_input();
			for (MoreProvidedCoupons mcoupons : partner.getListprovidedcoupins()) {
				totalProvinideCount += mcoupons.getCouponscount();
			}
			for (DistributedCoupons dcoupons : partner.getListdistCoupons()) {
				totaldistcount += dcoupons.getCouponsdistributed();
			}

			ucoupons = partner.getListusedcoupins().size();

			partner.setCoupon_provided_num_input(totalProvinideCount);
			partner.setDcoupon_distributed_count(totaldistcount);
			partner.setUsed_coupon_count(ucoupons);
			partnerrepo.saveAll(plist);
		}
		return new ResponseEntity<List<AddPartner>>(plist, HttpStatus.OK);
	}

	@GetMapping("/getdashboard")
	public HashMap<String, Object> getDasBoard() {
		HashMap<String, Object> obj = new HashMap<>();

		int partnerslist = partnerrepo.findAll().size();
		int usedcouponslist = usedrepo.findAll().size();
		
		List<AddPartner> plist = partnerrepo.findAll();
		int totaldistributedcouponscount = 0;
		int totalprovidedcoupons = 0;
		int totalcouponsUsed = 0;
		for (AddPartner partner : plist) {
			totaldistributedcouponscount += partner.getDcoupon_distributed_count();
			totalprovidedcoupons += partner.getCoupon_provided_num_input();
			totalcouponsUsed += partner.getUsed_coupon_count();

			obj.put("Total no of DistributedCoupons", totaldistributedcouponscount);
			obj.put("Total no of ProvidedCoupons", totalprovidedcoupons);
			obj.put("Total no of CouponsUsed", totalcouponsUsed);
		}

		obj.put("Total no of Partners", partnerslist);
		obj.put("Total no of UsedCoupons", usedcouponslist);
		return obj;
	}

	@PutMapping("updatepartners")
	public ResponseEntity<AddPartner> updatePartner(@RequestBody AddPartner partner) {

		AddPartner response = addPartnerService.savePartrner(partner);
		return new ResponseEntity<AddPartner>(response, HttpStatus.OK);

	}

	@GetMapping("/fetcbyId/{id}")
	public ResponseEntity<AddPartner> fetchUserById(@PathVariable(value = "id") Integer id) {
		AddPartner fecthbyid = addPartnerService.fetchPartnerById(id);
		return new ResponseEntity<AddPartner>(fecthbyid, HttpStatus.OK);
	}
	/*
	 * @GetMapping("partnersveiw/{id}") public ResponseEntity<HashMap<String,
	 * Object>> getPartnerVeiw(@PathVariable(value = "id") Integer id) {
	 * HashMap<String, Object> object = new HashMap<>(); AddPartner addPartner =
	 * addPartnerService.fetchPartnerById(id);
	 * 
	 * int addPartners = addPartnerService.getAllPartner().size(); List<AddPartner>
	 * details = addPartnerService.getAllPartner(); if (addPartner != null) { int
	 * provideCount = addPartner.getCoupon_provided_num_input(); int
	 * moreprovidedcount = 0; int distributedcoupons = 0; int size =
	 * addPartner.getListusedcoupins().size();
	 * 
	 * 
	 * 
	 * for (DistributedCoupons distcoupons : addPartner.getListdistCoupons()) {
	 * distributedcoupons += distcoupons.getCouponsdistributed(); } if (addPartner
	 * != null) { int partnerprovidecount =
	 * addPartner.getCoupon_provided_num_input();
	 * 
	 * for (MoreProvidedCoupons m : addPartner.getListprovidedcoupins()) {
	 * 
	 * partnerprovidecount += m.getCouponscount();
	 * 
	 * addPartner.setCoupon_provided_num_input(partnerprovidecount); }
	 * 
	 * }
	 * 
	 * object.put("Total no of coupons provided", provideCount);
	 * 
	 * object.put("moreProvidedCouponCount", moreprovidedcount); //
	 * object.put("partner details", addPartner);
	 * object.put("Total no of CouponsDistributed", distributedcoupons);
	 * object.put("Total no of Customers ", size);
	 * object.put("Total No of Partners", addPartners); object.put("response",
	 * "data found for partner id " + id); object.put("statusCode", 200);
	 * object.put("UsedCouponsCount", GetUsedCouponCount()); //
	 * object.put("databaseCouponCount", GetUsedCoupon(addPartner));
	 * object.put("partners list", details);
	 * 
	 * } else { object.put("response", "No data found for the partner id " + id);
	 * object.put("statusCode", 500); }
	 * 
	 * return new ResponseEntity<HashMap<String, Object>>(object, HttpStatus.OK);
	 * 
	 * }
	 */
	// UsedCoupons Count

	public HashMap<String, Integer> GetUsedCouponCount() {
		HashMap<String, Integer> object1 = new HashMap<>();
		List<UsedCoupons> list = usedrepo.findAll();

		for (UsedCoupons coupons : list) {
			if (object1.get(coupons.getUsedcouponCode()) == null) {
				object1.put(coupons.getUsedcouponCode(), 1);
			} else {
				object1.put(coupons.getUsedcouponCode(), object1.get(coupons.getUsedcouponCode()) + 1);

			}
		}
		return object1;

	}

// Partners coupon count updating

	/*
	 * public HashMap<String, Integer> GetUsedCoupon(AddPartner partner) {
	 * HashMap<String, Integer> object1 = new HashMap<>(); int pcount =
	 * partner.getCoupon_provided_num_input();
	 * 
	 * List<MoreProvidedCoupons> list = morerepo.findAll(); for (MoreProvidedCoupons
	 * c : list) { if (partner.getPartner_id() == c.getProvidedcouponsid()) {
	 * 
	 * pcount += c.getCouponscount();
	 * 
	 * } partner.setCoupon_provided_num_input(pcount);
	 * 
	 * }
	 * 
	 * object1.put("couponcountttttt", pcount);
	 * 
	 * return object1;
	 * 
	 * }
	 */

	/*
	 * @PutMapping("/update/partnersdetails/{partner_id}") public AddPartner
	 * updatepartner(@PathVariable Integer partner_id, @RequestBody AddPartner
	 * partner) { return partnerrepo.findById(partner_id).map(update -> {
	 * update.setCompany_name_input(partner.getCompany_name_input());
	 * update.setCoupon_code_input(partner.getCoupon_code_input());
	 * update.setAddress_city_input(partner.getAddress_city_input());
	 * update.setAddress_pincode_input(partner.getAddress_pincode_input());
	 * update.setAddress_state_input(partner.getAddress_state_input());
	 * update.setAddress_street_input(partner.getAddress_street_input());
	 * update.setBank_acname_input(partner.getBank_acname_input());
	 * update.setBank_acno_input(partner.getBank_acno_input());
	 * update.setBank_gstin_input(partner.getBank_gstin_input());
	 * update.setBank_ifsc_input(partner.getBank_ifsc_input());
	 * update.setCompany_type_input(partner.getCompany_type_input());
	 * update.setCoupon_provided_date_input(partner.getCoupon_provided_date_input())
	 * ;
	 * update.setCoupon_provided_num_input(partner.getCoupon_provided_num_input());
	 * update.setPayment_amount_input(partner.getPayment_amount_input());
	 * update.setPayment_date_input(partner.getPayment_date_input());
	 * update.setPerson_contactno_input(partner.getPerson_contactno_input());
	 * update.setPerson_email_input(partner.getPerson_email_input());
	 * update.setPerson_name_input(partner.getPerson_name_input());
	 * 
	 * return partnerrepo.save(update);
	 * 
	 * }).orElseThrow(() -> new ResourceNotFoundException("dist_id " + partner_id +
	 * "not found"));
	 * 
	 * }
	 */

	/*
	 * @GetMapping("partnersveiw/{id}") public ResponseEntity<HashMap<String,
	 * Object>> getPartnerVeiw(@PathVariable(value = "id") Integer id) {
	 * HashMap<String, Object> object = new HashMap<>(); AddPartner addPartner =
	 * addPartnerService.fetchPartnerById(id); if (addPartner != null) { int
	 * provideCount = addPartner.getCoupon_provided_num_input(); int
	 * moreprovidedcount = 0; int distributedcoupons = 0; int usedcouponscount = 0;
	 * 
	 * List<AddPartner> partnerdetails = addPartnerService.getAllPartner();
	 * 
	 * AddPartner partnerlist = addPartnerService.fetchPartnerById(id);
	 * 
	 * String address = partnerlist.getAddress_city_input(); Integer pincode =
	 * partnerlist.getAddress_pincode_input(); String state =
	 * partnerlist.getAddress_state_input(); String street =
	 * partnerlist.getAddress_street_input(); String acountname =
	 * partnerlist.getBank_acname_input(); long accountno =
	 * partnerlist.getBank_acno_input(); String gstin =
	 * partnerlist.getBank_gstin_input();
	 * 
	 * String ifsc = partnerlist.getBank_ifsc_input();
	 * 
	 * String companyname = partnerlist.getCompany_name_input();
	 * 
	 * String companytype = partnerlist.getCompany_type_input();
	 * 
	 * String couponcode = partnerlist.getCoupon_code_input();
	 * 
	 * String contatctno = partnerlist.getPerson_contactno_input();
	 * 
	 * String email = partnerlist.getPerson_email_input();
	 * 
	 * String personname = partnerlist.getPerson_name_input();
	 * 
	 * Date couponprovideddate = partnerlist.getCoupon_provided_date_input();
	 * 
	 * Integer couponcount = partnerlist.getCoupon_provided_num_input(); Integer
	 * paymentamount = partnerlist.getPayment_amount_input(); Date paymentdate =
	 * partnerlist.getPayment_date_input();
	 * 
	 * 
	 * for (DistributedCoupons distributedCoupons : addPartner.getListdistCoupons())
	 * {
	 * 
	 * provideCount += distributedCoupons.getNo_of_more_providedCoupons();
	 * moreprovidedcount += distributedCoupons.getNo_of_more_providedCoupons();
	 * 
	 * } for (DistributedCoupons distcoupons : addPartner.getListdistCoupons()) {
	 * distributedcoupons += distcoupons.getCouponsdistributed(); }
	 * 
	 * for (UsedCoupons usedcoupons : addPartner.getListusedcoupins()) {
	 * usedcouponscount += usedcoupons.getUsedcouponCode().length(); }
	 * 
	 * object.put("providedCouponCount", provideCount);
	 * object.put("moreProvidedCouponCount", moreprovidedcount);
	 * object.put("partner details", partnerdetails);
	 * object.put("Total_distributed_Coupons ", distributedcoupons);
	 * object.put("Total_Used_Coupons ", usedcouponscount); object.put("response",
	 * "data found for partner id " + id); object.put("statusCode", 200);
	 * 
	 * object.put("getAddress_city_input", address);
	 * object.put("getAddress_pincode_input", pincode);
	 * object.put("getAddress_state_input", state);
	 * object.put("getAddress_street_input", street);
	 * object.put("getBank_acname_input", acountname);
	 * object.put("getBank_acno_input", accountno);
	 * 
	 * object.put("getPayment_date_input", paymentdate);
	 * object.put("getPayment_amount_input", paymentamount);
	 * object.put("getCoupon_provided_num_input", couponcount);
	 * object.put("getCoupon_provided_date_input", couponprovideddate);
	 * 
	 * object.put("getPerson_name_input", personname);
	 * object.put("getPerson_email_input", email);
	 * 
	 * object.put("getPerson_contactno_input", contatctno);
	 * 
	 * object.put("getBank_ifsc_input", ifsc);
	 * 
	 * object.put("getCompany_name_input", companyname);
	 * object.put("getBank_gstin_input", gstin); object.put("getCompany_type_input",
	 * companytype); object.put("getCoupon_code_input", couponcode);
	 * object.put("getPayment_amount_input", paymentamount);
	 * 
	 * object.put("getPayment_date_input", paymentdate);
	 * 
	 * 
	 * } else { object.put("response", "No data found for the partner id " + id);
	 * object.put("statusCode", 500); }
	 * 
	 * return new ResponseEntity<HashMap<String, Object>>(object, HttpStatus.OK); }
	 */

}
