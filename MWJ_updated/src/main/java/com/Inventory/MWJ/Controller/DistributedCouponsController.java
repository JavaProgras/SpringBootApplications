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
import com.Inventory.MWJ.Model.DistributedCoupons;
import com.Inventory.MWJ.Repository.AddPartnerRepository;
import com.Inventory.MWJ.Repository.DistributedCouponsRepository;
import com.Inventory.MWJ.Service.DistributedCouponsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dpi")
public class DistributedCouponsController {

	@Autowired
	private DistributedCouponsService couponService;

	@Autowired
	private AddPartnerRepository partnerrepo;
	@Autowired
	private DistributedCouponsRepository distrepo;

	/*
	 * @PostMapping("/couponsave/{id}") public DistributedCoupons
	 * distcoupon(@RequestBody DistributedCoupons distcoupon,@PathVariable Integer
	 * id) {
	 * 
	 * return couponService.saveorupdate(distcoupon);
	 * 
	 * 
	 * }
	 */

	@PostMapping("/couponsave/{partner_id}")
	public DistributedCoupons createdistcoupons(@PathVariable(value = "partner_id") Integer partner_id,
			@Valid @RequestBody DistributedCoupons distcoupons) {
		return partnerrepo.findById(partner_id).map(partner -> {
			distcoupons.setPartner(partner);
			return distrepo.save(distcoupons);
		}).orElseThrow(() -> new ResourceNotFoundException("partner_id " + partner_id + " not found"));
	}

	@GetMapping("/fetchallcoupons")
	public List<DistributedCoupons> getAll() {
		return couponService.getAll();

	}

	/*
	 * @GetMapping("/partner/{postId}/distcoupons") public Page<DistributedCoupons>
	 * getAllCommentsByPostId(@PathVariable (value = "partner_id") Integer
	 * partner_id, Pageable pageable) { return distrepo.findByPartnerId(partner_id,
	 * pageable); }
	 */

	@PutMapping("/partner/{partner_id}/dist/{dist_id}")
	public DistributedCoupons updatedistcoupons(@PathVariable(value = "partner_id") Integer partner_id,
			@PathVariable(value = "dist_id") Integer dist_id, @Valid @RequestBody DistributedCoupons distcoupons) {
		if (!partnerrepo.existsById(partner_id)) {
			throw new ResourceNotFoundException("partner_id " + partner_id + " not found");
		}

		return distrepo.findById(dist_id).map(comment -> {
			comment.setCompanyname(distcoupons.getCompanyname());

			return distrepo.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("dist_id " + dist_id + "not found"));
	}

	@DeleteMapping("/deletecoupon/{id}")
	public String addPartner(@PathVariable(value = "id") Integer id) {
		couponService.deleteCoupon(id);
		return "Deleted Coupon Detasils Successfully...id=" + id;

	}

}
