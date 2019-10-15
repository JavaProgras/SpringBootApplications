package com.Inventory.MWJ.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.MWJ.Model.UsedCoupons;
import com.Inventory.MWJ.Repository.UsedCouponsCRepository;

@Service
public class UsedCouponsServiceImpl implements UsedCouponsService {

	@Autowired
	private UsedCouponsCRepository usedrepo;

	@Override
	public UsedCoupons saveUsedCoupons(UsedCoupons usedcoupons) {
		return usedrepo.save(usedcoupons);
	}

	@Override
	public String deleteusedcoupons(Integer id) {
		usedrepo.deleteById(id);
		return "Deleted Successfully...." + id;
	}

	@Override
	public List<UsedCoupons> getAllusedCouponsCode() {
		return usedrepo.findAll();
	}

	@Override
	public UsedCoupons fetchusedcouponById(Integer id) {
		return usedrepo.findById(id).get();
	}

	@Override
	public UsedCoupons updateUsedCoupons(UsedCoupons usedcoupons) {
		return null;
	}

	@Override
	public List<String> getAllCouponCode() {
		return usedrepo.getUsedCouponCode();
	}

	@Override
	public Long getUsedCouponCOunt() {
		return usedrepo.usedCouponcount();
	}

}
