package com.Inventory.MWJ.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.MWJ.Model.BseData;
import com.Inventory.MWJ.Repository.BseDataRepository;

import antlr.collections.List;

@Service
public class BseDataServiceImpl implements BseDataService {

	@Autowired
	private BseDataRepository bserepo;

	@Override
	public void setData() throws IOException {

		FileInputStream fileinput = new FileInputStream("src/main/resources/Bse.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Row row;

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);

			BseData bse = new BseData();
			bse.setUniqueNo(row.getCell(0).getNumericCellValue());
			bse.setSchemeCode(row.getCell(1).getStringCellValue());
			bse.setRtaSchemCode(row.getCell(2).toString());
			bse.setAmcSchemeCode(row.getCell(3).toString());
			bse.setIsin(row.getCell(4).toString());

			/*
			 * bse.setAmcCode(row.getCell(5).toString());
			 * 
			 * bse.setSchemetype(row.getCell(6).toString());
			 * 
			 * bse.setSchemePlan(row.getCell(7).toString());
			 * 
			 * bse.setSchemename(row.getCell(8).toString());
			 * 
			 * bse.setPurchaseAllowed(row.getCell(9).toString());
			 * 
			 * bse.setPurchaseTransactionmode(row.getCell(10).toString());
			 * 
			 * bse.setMinimumPurchaseAmount(row.getCell(11).toString());
			 * 
			 * bse.setAdditionalPurchaseAmount(row.getCell(12).toString());
			 * 
			 * bse.setMaximumPurchaseAmount(row.getCell(13).toString());
			 * 
			 * bse.setPurchaseAmountMultiplier(row.getCell(14).toString());
			 * 
			 * bse.setPurchaseCutoffTime(row.getCell(15).toString());
			 * 
			 * bse.setRedemptionAllowed(row.getCell(16).toString());
			 * 
			 * bse.setRedemptionTransactionMode(row.getCell(17).toString());
			 * 
			 * bse.setMinimumRedemptionQty(row.getCell(18).toString());
			 * 
			 * bse.setRedemptionQtyMultiplier(row.getCell(19).toString());
			 * bse.setMinimumRedemptionQty(row.getCell(20).toString());
			 * 
			 * bse.setRedemptionAmount_Minimum(row.getCell(21).toString());
			 * 
			 * bse.setRedemptionAmount_Maximum(row.getCell(22).toString());
			 * 
			 * bse.setRedemptionAmountMultiple(row.getCell(23).toString());
			 * 
			 * bse.setRedemptionCut_offTime(row.getCell(24).toString());
			 * 
			 * bse.setRtaAgentCode(row.getCell(25).toString());
			 * bse.setAmcActiveFlag(row.getCell(26).toString());
			 * 
			 * bse.setDividendReinvestmentFlag(row.getCell(27).toString());
			 * 
			 * bse.setSip_flag(row.getCell(28).toString());
			 * 
			 * bse.setStp_flag(row.getCell(29).toString());
			 * 
			 * bse.setSwp_flag(row.getCell(30).toString());
			 * 
			 * bse.setSwitch_flag(row.getCell(31).toString());
			 * bse.setsETTLEMENTTYPE(row.getCell(32).toString());
			 * 
			 * bse.setFace_value(row.getCell(33).toString());
			 * 
			 * bse.setStart_date(row.getCell(34).toString());
			 * bse.setEnd_date(row.getCell(35).toString());
			 * bse.setExit_load_flag(row.getCell(36).toString());
			 * bse.setExit_load(row.getCell(37).toString());
			 * bse.setLock_inPeriodFlag(row.getCell(38).toString());
			 * 
			 * bse.setLockinPeriod(row.getCell(39).toString());
			 * 
			 * bse.setChannelPartnerCode(row.getCell(40).toString());
			 */
			bserepo.save(bse);
		}

	}

	@Override
	public BseData setData(BseData bsedata) {
		return bserepo.save(bsedata);
	}

}
