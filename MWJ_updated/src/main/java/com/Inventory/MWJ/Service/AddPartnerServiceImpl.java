package com.Inventory.MWJ.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.MWJ.Model.AddPartner;
import com.Inventory.MWJ.Repository.AddPartnerRepository;

@Service
public class AddPartnerServiceImpl implements AddPartnerService {

	@Autowired
	private AddPartnerRepository addPartnerRepository;

	@Override
	public AddPartner savePartrner(AddPartner addPartner) {
		
		return addPartnerRepository.save(addPartner);
	}

	@Override
	public String deletePartner(Integer id) {
		addPartnerRepository.deleteById(id);
		return "deleted successfully";
	}

	@Override
	public List<AddPartner> getAllPartner() {

		return addPartnerRepository.findAll();
	}

	@Override
	public AddPartner fetchPartnerById(Integer id) {
		Optional<AddPartner> optionalPartner = addPartnerRepository.findById(id);
		if (optionalPartner.isPresent())
			return optionalPartner.get();
		else
			return null;
	}

	@Override
	public AddPartner UpdatePartrner(AddPartner addPartner) {
		return addPartnerRepository.save(addPartner);
	}

	@Override
	public AddPartner fetchPartnerByCouponcode(String couponcode) {
		return addPartnerRepository.find(couponcode);
	}

}
