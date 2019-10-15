package com.Inventory.MWJ.Service;

import java.util.List;

import com.Inventory.MWJ.Model.SubPartners;

public interface SubpartnersService {

	public SubPartners save(Integer partner_id,SubPartners subpartners);
	
	public List<SubPartners> listallSUbParners();
	
}
