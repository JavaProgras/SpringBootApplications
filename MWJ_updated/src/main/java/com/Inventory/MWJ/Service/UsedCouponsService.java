package com.Inventory.MWJ.Service;

import java.util.List;

import com.Inventory.MWJ.Model.UsedCoupons;

public interface UsedCouponsService {

	public UsedCoupons saveUsedCoupons(UsedCoupons usedcoupons);

	public UsedCoupons updateUsedCoupons(UsedCoupons usedcoupons);

	public String deleteusedcoupons(Integer id);

	public List<UsedCoupons> getAllusedCouponsCode();

	public UsedCoupons fetchusedcouponById(Integer id);
	
	public List<String> getAllCouponCode();

	public Long getUsedCouponCOunt();
}
