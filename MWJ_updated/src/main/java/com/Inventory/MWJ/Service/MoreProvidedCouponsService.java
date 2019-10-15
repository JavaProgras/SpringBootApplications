package com.Inventory.MWJ.Service;

import java.util.List;

import com.Inventory.MWJ.Model.MoreProvidedCoupons;

public interface MoreProvidedCouponsService {

	public MoreProvidedCoupons saveProvidedCoupon(MoreProvidedCoupons providedcoupons);

	public MoreProvidedCoupons UpdatePartrner(MoreProvidedCoupons providedcoupons);

	public String deletecoupon(long id);

	public List<MoreProvidedCoupons> getAllprovidedCoupons();

	public MoreProvidedCoupons fetchprovidedcouponsById(Integer id);
	


}
