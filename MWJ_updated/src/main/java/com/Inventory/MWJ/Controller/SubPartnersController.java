package com.Inventory.MWJ.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Model.SubPartners;
import com.Inventory.MWJ.Service.SubpartnersService;

@RestController
@RequestMapping("/subpartnerdetails")
public class SubPartnersController {

	@Autowired
	private SubpartnersService subservice;

	@PostMapping("/save/{partner_id}")
	public SubPartners saveSubPartners(@PathVariable(value = "partner_id") Integer partner_id,
			@RequestBody SubPartners subpartners) {
		return subservice.save(partner_id, subpartners);
	}

}
