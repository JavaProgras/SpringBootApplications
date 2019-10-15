package com.Inventory.MWJ.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Exceptions.ResourceNotFoundException;
import com.Inventory.MWJ.Model.UsedCoupons;
import com.Inventory.MWJ.Repository.AddPartnerRepository;
import com.Inventory.MWJ.Repository.UsedCouponsCRepository;
import com.Inventory.MWJ.Service.UsedCouponsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/upi")
public class UsedCouponsController {

	@Autowired
	private UsedCouponsService usedservice;

	@Autowired
	private UsedCouponsCRepository usedrepo;

	@Autowired
	private AddPartnerRepository partnerrepo;

	/*
	 * @PostMapping("/save") public UsedCoupons assusedcoupons(@RequestBody
	 * UsedCoupons addusedcoupons) { return
	 * usedservice.saveorupdateusedcoupons(addusedcoupons);
	 * 
	 */

	/*
	 * @PostMapping("/usedcouponsave/{dist_id}") public UsedCoupons
	 * createusedcoupons(@PathVariable(value = "dist_id") Integer dist_id,
	 * 
	 * @Valid @RequestBody UsedCoupons usedcoupons) { return
	 * partnerrepo.findById(dist_id).map(distcoupons -> {
	 * usedcoupons.setDistcoupons(distcoupons); return usedrepo.save(usedcoupons);
	 * }).orElseThrow( () -> new
	 * com.spring.Exception.ResourceNotFoundException("dist_id " + dist_id +
	 * " not found")); }
	 */

	@PostMapping("/usedcouponsave/{partner_id}")
	public UsedCoupons createusedcoupons(@PathVariable(value = "partner_id") Integer partner_id,

			@Valid @RequestBody UsedCoupons usedcoupons) {
		return partnerrepo.findById(partner_id).map(partner -> {
			usedcoupons.setPartner(partner);
			return usedrepo.save(usedcoupons);
		}).orElseThrow(() -> new ResourceNotFoundException("partner_id " + partner_id + " not found"));
	}

	@DeleteMapping("/delete/{id}")
	public String deleteusedcoupons(@PathVariable(value = "id") Integer id) {
		usedservice.deleteusedcoupons(id);
		return "Deleted Successfully..." + id;
	}

	@GetMapping("/getusedcoupons")
	public List<UsedCoupons> getAllUsedCoupons() {

		return usedservice.getAllusedCouponsCode();

	}

	@PutMapping("/partner/{partner_id}/usedcoupon/{usedcoupon_id}")
	public UsedCoupons updateusedcoupons(@PathVariable(value = "partner_id") Integer partner_id,
			@PathVariable(value = "usedcoupon_id") Integer usedcoupon_id, @Valid @RequestBody UsedCoupons usedcoupons) {
		if (!partnerrepo.existsById(partner_id)) {
			throw new ResourceNotFoundException("partner_id " + partner_id + " not found");
		}

		return usedrepo.findById(usedcoupon_id).map(update -> {
			update.setUcc_code(usedcoupons.getUcc_code());
			update.setCustomername(usedcoupons.getCustomername());
			update.setUsedcoupon_code_date(usedcoupons.getUsedcoupon_code_date());
			update.setUsedcouponCode(usedcoupons.getUsedcouponCode());

			return usedrepo.save(update);

		}).orElseThrow(() -> new ResourceNotFoundException("usedcoupon_id " + usedcoupon_id + "not found"));
	}

	@GetMapping("/fetcbyId/{id}")
	public UsedCoupons fetchUserById(@PathVariable(value = "id") Integer id) {
		return usedservice.fetchusedcouponById(id);

	}

	@GetMapping("/getcouponcode")
	public List<String> getCouponsUsed() {
		return usedservice.getAllCouponCode();
	}

	@GetMapping("/getcouponscount")
	public Long getUsedCouponsCount()

	{
		return usedservice.getUsedCouponCOunt();
	}

}