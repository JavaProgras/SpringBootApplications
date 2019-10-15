package com.Inventory.MWJ.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Model.PrinterInfo;
import com.Inventory.MWJ.Service.PrinterInfoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/printerinfo")
public class PrinterInfoController {

	@Autowired
	private PrinterInfoService printerservice;

	@PostMapping("/save")
	public ResponseEntity<PrinterInfo> savePrinterinfo(@RequestBody PrinterInfo printinfo) {

		PrinterInfo prinnterinfo = printerservice.saveprinter(printinfo);
		return new ResponseEntity<PrinterInfo>(prinnterinfo, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<PrinterInfo> updatePrinterinfo(@RequestBody PrinterInfo printinfo) {

		PrinterInfo prinnterinfo = printerservice.updatePartner(printinfo);
		return new ResponseEntity<PrinterInfo>(prinnterinfo, HttpStatus.OK);
	}

}
