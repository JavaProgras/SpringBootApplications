package com.Inventory.MWJ.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.MWJ.Model.PrinterInfo;
import com.Inventory.MWJ.Repository.PrinterInfoRepository;

@Service
public class PrinnterInfoServiceImpl implements PrinterInfoService {

	@Autowired
	private PrinterInfoRepository printerrepo;

	@Override
	public PrinterInfo saveprinter(PrinterInfo printinfo) {

		return printerrepo.save(printinfo);
	}

	@Override
	public PrinterInfo updatePartner(PrinterInfo printinfo) {
		return printerrepo.save(printinfo);
	}

}
