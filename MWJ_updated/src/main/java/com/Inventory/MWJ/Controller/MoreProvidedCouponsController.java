package com.Inventory.MWJ.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Exceptions.ResourceNotFoundException;
import com.Inventory.MWJ.Model.MoreProvidedCoupons;
import com.Inventory.MWJ.Repository.AddPartnerRepository;
import com.Inventory.MWJ.Repository.MoreProvidedCouponsRepository;
import com.Inventory.MWJ.Service.MoreProvidedCouponsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mpc")
public class MoreProvidedCouponsController {

	@Autowired
	private MoreProvidedCouponsService moreprovidedcouponsservice;
	@Autowired
	private AddPartnerRepository partnerrepo;
	@Autowired
	private MoreProvidedCouponsRepository moreprovidedrepo;

	@PostMapping("/save/{partner_id}")
	public MoreProvidedCoupons saveorupdate(@PathVariable(value = "partner_id") Integer partner_id,
			@Valid @RequestBody MoreProvidedCoupons providedcoupons) {
		return partnerrepo.findById(partner_id).map(partner -> {
			providedcoupons.setPartner(partner);

			return moreprovidedrepo.save(providedcoupons);
		}).orElseThrow(() -> new ResourceNotFoundException("partner_id " + partner_id + " not found"));
	}



	@PutMapping("/update/moreprovidedcoupons/{provided_couponsid}")
	public MoreProvidedCoupons updateCoupons(@PathVariable Integer provided_couponsid,
			@RequestBody MoreProvidedCoupons mpcoupons) {
		return moreprovidedrepo.findById(provided_couponsid).map(update -> {
			update.setCompanyname(mpcoupons.getCompanyname());
			update.setCoupon_code(mpcoupons.getCoupon_code());
			update.setCouponscount(mpcoupons.getCouponscount());
			update.setCouponsprovideddate(mpcoupons.getCouponsprovideddate());
			return moreprovidedrepo.save(update);
		}).orElseThrow(() -> new ResourceNotFoundException("dist_id " + provided_couponsid + "not found"));
	}

	@GetMapping("getall")
	public List<MoreProvidedCoupons> getAll() {
		return moreprovidedcouponsservice.getAllprovidedCoupons();

	}

}
