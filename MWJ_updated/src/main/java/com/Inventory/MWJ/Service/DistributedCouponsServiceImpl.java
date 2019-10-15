package com.Inventory.MWJ.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.MWJ.Model.DistributedCoupons;
import com.Inventory.MWJ.Repository.DistributedCouponsRepository;



@Service
public class DistributedCouponsServiceImpl implements DistributedCouponsService {

	
	@Autowired
	private DistributedCouponsRepository distcoupons;
	
	@Override
	public DistributedCoupons saveorupdate(DistributedCoupons distcoupon) {
		return distcoupons.save(distcoupon) ;
	}

	@Override
	public List<DistributedCoupons> getAll() {
		return distcoupons.findAll();
	}

	@Override
	public String deleteCoupon(Integer id) {
		distcoupons.deleteById(id);
		return "Deleted Succesfully....your"+id;
	}

	@Override
	public DistributedCoupons fetchbyid(Integer id) {
		return distcoupons.findById(id).get();
	}

}
