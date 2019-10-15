package com.Inventory.MWJ.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.MWJ.Model.MoreProvidedCoupons;
import com.Inventory.MWJ.Repository.MoreProvidedCouponsRepository;

@Service
public class MoreProvidedCouponsServiceImpl implements MoreProvidedCouponsService {

	@Autowired
	private MoreProvidedCouponsRepository providedcouponsrepositroy;

	@Override
	public MoreProvidedCoupons saveProvidedCoupon(MoreProvidedCoupons providedcoupons) {

		return providedcouponsrepositroy.save(providedcoupons);
	}

	@Override
	public String deletecoupon(long id) {
		return "deleted SuccesFully..." + id;
	}

	@Override
	public List<MoreProvidedCoupons> getAllprovidedCoupons() {
		return null;
	}

	@Override
	public MoreProvidedCoupons fetchprovidedcouponsById(Integer id) {
		Optional<MoreProvidedCoupons> optionalProvidedcoupons = providedcouponsrepositroy.findById(id);
		if (optionalProvidedcoupons.isPresent())
			return optionalProvidedcoupons.get();
		else
			return null;
	}

	@Override
	public MoreProvidedCoupons UpdatePartrner(MoreProvidedCoupons providedcoupons) {
		return null;
	}

}
