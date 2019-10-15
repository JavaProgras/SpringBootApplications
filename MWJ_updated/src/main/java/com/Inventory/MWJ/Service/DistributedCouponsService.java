package com.Inventory.MWJ.Service;

import java.util.List;

import com.Inventory.MWJ.Model.DistributedCoupons;


public interface DistributedCouponsService {


	public DistributedCoupons saveorupdate(DistributedCoupons distcoupon);
	public List<DistributedCoupons> getAll();
	public String deleteCoupon(Integer id );
	public DistributedCoupons fetchbyid(Integer id);
	
	
}
