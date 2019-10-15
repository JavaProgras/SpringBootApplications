package com.Inventory.MWJ.Service;

import java.util.List;

import com.Inventory.MWJ.Model.AddPartner;

public interface AddPartnerService {

	public AddPartner savePartrner(AddPartner addPartner);

	public AddPartner UpdatePartrner(AddPartner addPartner);

	public String deletePartner(Integer id);

	public List<AddPartner> getAllPartner();
	

	public AddPartner fetchPartnerById(Integer id);

	public AddPartner fetchPartnerByCouponcode(String couponcode);


}
