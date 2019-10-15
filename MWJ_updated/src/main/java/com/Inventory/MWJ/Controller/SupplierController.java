package com.Inventory.MWJ.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Model.SupplierInfo;

import com.Inventory.MWJ.Service.SupplierInfoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/supplierdetails")
public class SupplierController {

	@Autowired
	private SupplierInfoService supplierservice;

	@PostMapping("/save/{order_id}")
	public ResponseEntity<SupplierInfo> saveSupplierdetails(@PathVariable(value = "order_id") Integer order_id,
			@Valid @RequestBody SupplierInfo supplierinfo) {

		SupplierInfo supplier = supplierservice.saveSupplierdetails(order_id, supplierinfo);
		return new ResponseEntity<SupplierInfo>(supplier, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<SupplierInfo> updateSupplierdetails(@RequestBody SupplierInfo supplierdetails) {
		SupplierInfo supplier = supplierservice.updateSupplierdetails(supplierdetails);
		return new ResponseEntity<SupplierInfo>(supplier, HttpStatus.OK);
	}

}
