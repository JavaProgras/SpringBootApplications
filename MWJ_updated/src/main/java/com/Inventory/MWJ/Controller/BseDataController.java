package com.Inventory.MWJ.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Service.BseDataService;

@RestController
@RequestMapping("/bse")
public class BseDataController {

	@Autowired
	private BseDataService bseservice;

	@PostMapping("/save")
	public String saveData() throws IOException {
			bseservice.setData();
			return "Inserted .......SuccessFully";
	}
}
