package com.Inventory.MWJ.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bse_schema")
public class BseData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bse_id;
	private String name;
	private String names;
	private double uniqueNo;
	private String schemeCode;
	private String amcCode;
	private String rtaSchemCode;
	private String amcSchemeCode;
	private String isin;
	private String schemetype;
	private String schemePlan;

	private String schemename;

	private String purchaseAllowed;

	private String purchaseTransactionmode;

	private String minimumPurchaseAmount;

	private String additionalPurchaseAmount;

	private String maximumPurchaseAmount;

	private String purchaseAmountMultiplier;

	private String purchaseCutoffTime;

	private String redemptionAllowed;
	private String redemptionTransactionMode;
	private String minimumRedemptionQty;
	private String redemptionQtyMultiplier;
	private String maximumRedemptionQty;
	private String redemptionAmount_Minimum;
	private String redemptionAmount_Maximum;
	private String redemptionAmountMultiple;
	private String redemptionCut_offTime;
	private String rtaAgentCode;
	private String amcActiveFlag;
	private String dividendReinvestmentFlag;
	private String sip_flag;
	private String stp_flag;
	private String swp_flag;
	private String switch_flag;
	private String sETTLEMENTTYPE;
	private String face_value;
	private String start_date;
	private String end_date;
	private String exit_load_flag;

	private String exit_load;

	private String lock_inPeriodFlag;

	private String lockinPeriod;

	private String channelPartnerCode;

	public BseData() {

	}

	public BseData(int bse_id, double uniqueNo, String schemeCode, String amcCode, String rtaSchemCode,
			String amcSchemeCode, String isin, String schemetype, String schemePlan, String schemename,
			String purchaseAllowed, String purchaseTransactionmode, String minimumPurchaseAmount,
			String additionalPurchaseAmount, String maximumPurchaseAmount, String purchaseAmountMultiplier,
			String purchaseCutoffTime, String redemptionAllowed, String redemptionTransactionMode,
			String minimumRedemptionQty, String redemptionQtyMultiplier, String maximumRedemptionQty,
			String redemptionAmount_Minimum, String redemptionAmount_Maximum, String redemptionAmountMultiple,
			String redemptionCut_offTime, String rtaAgentCode, String amcActiveFlag, String dividendReinvestmentFlag,
			String sip_flag, String stp_flag, String swp_flag, String switch_flag, String sETTLEMENTTYPE,
			String face_value, String start_date, String end_date, String exit_load_flag, String exit_load,
			String lock_inPeriodFlag, String lockinPeriod, String channelPartnerCode, String name, String names) {
		super();
		this.bse_id = bse_id;
		this.uniqueNo = uniqueNo;
		this.schemeCode = schemeCode;
		this.amcCode = amcCode;
		this.rtaSchemCode = rtaSchemCode;
		this.amcSchemeCode = amcSchemeCode;
		this.isin = isin;
		this.schemetype = schemetype;
		this.schemePlan = schemePlan;
		this.schemename = schemename;
		this.purchaseAllowed = purchaseAllowed;
		this.purchaseTransactionmode = purchaseTransactionmode;
		this.minimumPurchaseAmount = minimumPurchaseAmount;
		this.additionalPurchaseAmount = additionalPurchaseAmount;
		this.maximumPurchaseAmount = maximumPurchaseAmount;
		this.purchaseAmountMultiplier = purchaseAmountMultiplier;
		this.purchaseCutoffTime = purchaseCutoffTime;
		this.redemptionAllowed = redemptionAllowed;
		this.redemptionTransactionMode = redemptionTransactionMode;
		this.minimumRedemptionQty = minimumRedemptionQty;
		this.redemptionQtyMultiplier = redemptionQtyMultiplier;
		this.maximumRedemptionQty = maximumRedemptionQty;
		this.redemptionAmount_Minimum = redemptionAmount_Minimum;
		this.redemptionAmount_Maximum = redemptionAmount_Maximum;
		this.redemptionAmountMultiple = redemptionAmountMultiple;
		this.redemptionCut_offTime = redemptionCut_offTime;
		this.rtaAgentCode = rtaAgentCode;
		this.amcActiveFlag = amcActiveFlag;
		this.dividendReinvestmentFlag = dividendReinvestmentFlag;
		this.sip_flag = sip_flag;
		this.stp_flag = stp_flag;
		this.swp_flag = swp_flag;
		this.switch_flag = switch_flag;
		this.sETTLEMENTTYPE = sETTLEMENTTYPE;
		this.face_value = face_value;
		this.start_date = start_date;
		this.end_date = end_date;
		this.exit_load_flag = exit_load_flag;
		this.exit_load = exit_load;
		this.lock_inPeriodFlag = lock_inPeriodFlag;
		this.lockinPeriod = lockinPeriod;
		this.channelPartnerCode = channelPartnerCode;
		this.name = name;
		this.names = names;
	}

	@Override
	public String toString() {
		return "BseData [bse_id=" + bse_id + ", uniqueNo=" + uniqueNo + ", schemeCode=" + schemeCode + ", amcCode="
				+ amcCode + ", rtaSchemCode=" + rtaSchemCode + ", amcSchemeCode=" + amcSchemeCode + ", isin=" + isin
				+ ", schemetype=" + schemetype + ", schemePlan=" + schemePlan + ", schemename=" + schemename
				+ ", purchaseAllowed=" + purchaseAllowed + ", purchaseTransactionmode=" + purchaseTransactionmode
				+ ", minimumPurchaseAmount=" + minimumPurchaseAmount + ", additionalPurchaseAmount="
				+ additionalPurchaseAmount + ", maximumPurchaseAmount=" + maximumPurchaseAmount
				+ ", purchaseAmountMultiplier=" + purchaseAmountMultiplier + ", purchaseCutoffTime="
				+ purchaseCutoffTime + ", redemptionAllowed=" + redemptionAllowed + ", redemptionTransactionMode="
				+ redemptionTransactionMode + ", minimumRedemptionQty=" + minimumRedemptionQty
				+ ", redemptionQtyMultiplier=" + redemptionQtyMultiplier + ", maximumRedemptionQty="
				+ maximumRedemptionQty + ", redemptionAmount_Minimum=" + redemptionAmount_Minimum
				+ ", redemptionAmount_Maximum=" + redemptionAmount_Maximum + ", redemptionAmountMultiple="
				+ redemptionAmountMultiple + ", redemptionCut_offTime=" + redemptionCut_offTime + ", rtaAgentCode="
				+ rtaAgentCode + ", amcActiveFlag=" + amcActiveFlag + ", dividendReinvestmentFlag="
				+ dividendReinvestmentFlag + ", sip_flag=" + sip_flag + ", stp_flag=" + stp_flag + ", swp_flag="
				+ swp_flag + ", switch_flag=" + switch_flag + ", sETTLEMENTTYPE=" + sETTLEMENTTYPE + ", face_value="
				+ face_value + ", start_date=" + start_date + ", end_date=" + end_date + ", exit_load_flag="
				+ exit_load_flag + ", exit_load=" + exit_load + ", lock_inPeriodFlag=" + lock_inPeriodFlag
				+ ", lockinPeriod=" + lockinPeriod + ", channelPartnerCode=" + channelPartnerCode + "]";
	}

	public int getBse_id() {
		return bse_id;
	}

	public void setBse_id(int bse_id) {
		this.bse_id = bse_id;
	}

	public double getUniqueNo() {
		return uniqueNo;
	}

	public void setUniqueNo(double d) {
		this.uniqueNo = d;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getAmcCode() {
		return amcCode;
	}

	public void setAmcCode(String amcCode) {
		this.amcCode = amcCode;
	}

	public String getRtaSchemCode() {
		return rtaSchemCode;
	}

	public void setRtaSchemCode(String rtaSchemCode) {
		this.rtaSchemCode = rtaSchemCode;
	}

	public String getAmcSchemeCode() {
		return amcSchemeCode;
	}

	public void setAmcSchemeCode(String amcSchemeCode) {
		this.amcSchemeCode = amcSchemeCode;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getSchemetype() {
		return schemetype;
	}

	public void setSchemetype(String schemetype) {
		this.schemetype = schemetype;
	}

	public String getSchemePlan() {
		return schemePlan;
	}

	public void setSchemePlan(String schemePlan) {
		this.schemePlan = schemePlan;
	}

	public String getSchemename() {
		return schemename;
	}

	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}

	public String getPurchaseAllowed() {
		return purchaseAllowed;
	}

	public void setPurchaseAllowed(String purchaseAllowed) {
		this.purchaseAllowed = purchaseAllowed;
	}

	public String getPurchaseTransactionmode() {
		return purchaseTransactionmode;
	}

	public void setPurchaseTransactionmode(String purchaseTransactionmode) {
		this.purchaseTransactionmode = purchaseTransactionmode;
	}

	public String getMinimumPurchaseAmount() {
		return minimumPurchaseAmount;
	}

	public void setMinimumPurchaseAmount(String minimumPurchaseAmount) {
		this.minimumPurchaseAmount = minimumPurchaseAmount;
	}

	public String getAdditionalPurchaseAmount() {
		return additionalPurchaseAmount;
	}

	public void setAdditionalPurchaseAmount(String additionalPurchaseAmount) {
		this.additionalPurchaseAmount = additionalPurchaseAmount;
	}

	public String getMaximumPurchaseAmount() {
		return maximumPurchaseAmount;
	}

	public void setMaximumPurchaseAmount(String maximumPurchaseAmount) {
		this.maximumPurchaseAmount = maximumPurchaseAmount;
	}

	public String getPurchaseAmountMultiplier() {
		return purchaseAmountMultiplier;
	}

	public void setPurchaseAmountMultiplier(String purchaseAmountMultiplier) {
		this.purchaseAmountMultiplier = purchaseAmountMultiplier;
	}

	public String getPurchaseCutoffTime() {
		return purchaseCutoffTime;
	}

	public void setPurchaseCutoffTime(String purchaseCutoffTime) {
		this.purchaseCutoffTime = purchaseCutoffTime;
	}

	public String getRedemptionAllowed() {
		return redemptionAllowed;
	}

	public void setRedemptionAllowed(String redemptionAllowed) {
		this.redemptionAllowed = redemptionAllowed;
	}

	public String getRedemptionTransactionMode() {
		return redemptionTransactionMode;
	}

	public void setRedemptionTransactionMode(String redemptionTransactionMode) {
		this.redemptionTransactionMode = redemptionTransactionMode;
	}

	public String getMinimumRedemptionQty() {
		return minimumRedemptionQty;
	}

	public void setMinimumRedemptionQty(String minimumRedemptionQty) {
		this.minimumRedemptionQty = minimumRedemptionQty;
	}

	public String getRedemptionQtyMultiplier() {
		return redemptionQtyMultiplier;
	}

	public void setRedemptionQtyMultiplier(String redemptionQtyMultiplier) {
		this.redemptionQtyMultiplier = redemptionQtyMultiplier;
	}

	public String getMaximumRedemptionQty() {
		return maximumRedemptionQty;
	}

	public void setMaximumRedemptionQty(String maximumRedemptionQty) {
		this.maximumRedemptionQty = maximumRedemptionQty;
	}

	public String getRedemptionAmount_Minimum() {
		return redemptionAmount_Minimum;
	}

	public void setRedemptionAmount_Minimum(String redemptionAmount_Minimum) {
		this.redemptionAmount_Minimum = redemptionAmount_Minimum;
	}

	public String getRedemptionAmount_Maximum() {
		return redemptionAmount_Maximum;
	}

	public void setRedemptionAmount_Maximum(String redemptionAmount_Maximum) {
		this.redemptionAmount_Maximum = redemptionAmount_Maximum;
	}

	public String getRedemptionAmountMultiple() {
		return redemptionAmountMultiple;
	}

	public void setRedemptionAmountMultiple(String redemptionAmountMultiple) {
		this.redemptionAmountMultiple = redemptionAmountMultiple;
	}

	public String getRedemptionCut_offTime() {
		return redemptionCut_offTime;
	}

	public void setRedemptionCut_offTime(String redemptionCut_offTime) {
		this.redemptionCut_offTime = redemptionCut_offTime;
	}

	public String getRtaAgentCode() {
		return rtaAgentCode;
	}

	public void setRtaAgentCode(String rtaAgentCode) {
		this.rtaAgentCode = rtaAgentCode;
	}

	public String getAmcActiveFlag() {
		return amcActiveFlag;
	}

	public void setAmcActiveFlag(String amcActiveFlag) {
		this.amcActiveFlag = amcActiveFlag;
	}

	public String getDividendReinvestmentFlag() {
		return dividendReinvestmentFlag;
	}

	public void setDividendReinvestmentFlag(String dividendReinvestmentFlag) {
		this.dividendReinvestmentFlag = dividendReinvestmentFlag;
	}

	public String getSip_flag() {
		return sip_flag;
	}

	public void setSip_flag(String sip_flag) {
		this.sip_flag = sip_flag;
	}

	public String getStp_flag() {
		return stp_flag;
	}

	public void setStp_flag(String stp_flag) {
		this.stp_flag = stp_flag;
	}

	public String getSwp_flag() {
		return swp_flag;
	}

	public void setSwp_flag(String swp_flag) {
		this.swp_flag = swp_flag;
	}

	public String getSwitch_flag() {
		return switch_flag;
	}

	public void setSwitch_flag(String switch_flag) {
		this.switch_flag = switch_flag;
	}

	public String getsETTLEMENTTYPE() {
		return sETTLEMENTTYPE;
	}

	public void setsETTLEMENTTYPE(String sETTLEMENTTYPE) {
		this.sETTLEMENTTYPE = sETTLEMENTTYPE;
	}

	public String getFace_value() {
		return face_value;
	}

	public void setFace_value(String face_value) {
		this.face_value = face_value;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getExit_load_flag() {
		return exit_load_flag;
	}

	public void setExit_load_flag(String exit_load_flag) {
		this.exit_load_flag = exit_load_flag;
	}

	public String getExit_load() {
		return exit_load;
	}

	public void setExit_load(String exit_load) {
		this.exit_load = exit_load;
	}

	public String getLock_inPeriodFlag() {
		return lock_inPeriodFlag;
	}

	public void setLock_inPeriodFlag(String lock_inPeriodFlag) {
		this.lock_inPeriodFlag = lock_inPeriodFlag;
	}

	public String getLockinPeriod() {
		return lockinPeriod;
	}

	public void setLockinPeriod(String lockinPeriod) {
		this.lockinPeriod = lockinPeriod;
	}

	public String getChannelPartnerCode() {
		return channelPartnerCode;
	}

	public void setChannelPartnerCode(String channelPartnerCode) {
		this.channelPartnerCode = channelPartnerCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

}
