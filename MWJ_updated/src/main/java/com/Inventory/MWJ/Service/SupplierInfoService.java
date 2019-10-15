package com.Inventory.MWJ.Service;

import com.Inventory.MWJ.Model.SupplierInfo;

public interface SupplierInfoService {

	public SupplierInfo saveSupplierdetails(Integer order_id,SupplierInfo supplierinfo);

	public SupplierInfo updateSupplierdetails(SupplierInfo supplierinfo);

}
