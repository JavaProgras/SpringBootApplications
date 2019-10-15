package com.Inventory.MWJ.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Inventory.MWJ.Exceptions.ResourceNotFoundException;
import com.Inventory.MWJ.Model.SubPartners;
import com.Inventory.MWJ.Repository.AddPartnerRepository;
import com.Inventory.MWJ.Repository.SubPartnersRepository;

@Service
public class SubPartnersServiceImpl implements SubpartnersService {

	@Autowired
	private SubPartnersRepository subpartnersrepo;

	@Autowired
	private AddPartnerRepository partnerrepo;

	@Override
	public SubPartners save(@PathVariable(value = "partner_id") Integer partner_id, SubPartners subpartners) {
		return partnerrepo.findById(partner_id).map(partner -> {

			subpartners.setPartner(partner);

			return subpartnersrepo.save(subpartners);
		}).orElseThrow(() -> new ResourceNotFoundException("partner_id" + partner_id + "not found"));

	}

	@Override
	public List<SubPartners> listallSUbParners() {
		return subpartnersrepo.findAll();
	}

}
