package com.tie.model;

import java.util.ArrayList;
import java.util.List;

public class TieDoc {
	private int tieDocId;
	private String name;
	private String code;
	private String description;
	private int tieDocTypeId;
	private int tieMsgId;
	private String reportingEntityCode;
	// TODO: object of ENtity
	private TieTaxEntity reportingEntity;

	private String currencyCode;
	private String resCountryCode;
	private String sourceDoc;
	private String accountingStandard;
	private String reportingPeriod;

	private List<TieTaxEntity> taxEntityList = new ArrayList<TieTaxEntity>();
	private List<CbcrTable1> cbcrTable1List = new ArrayList<CbcrTable1>();
	private List<CbcrTable2> cbcrTable2List = new ArrayList<CbcrTable2>();
	private List<CbcrTable3> cbcrTable3List = new ArrayList<CbcrTable3>();
	private String table3String;

	public TieDoc() {
		// super();
	}

	public TieDoc(int tieDocId, String name, String code, String description, int tieDocTypeId, int tieMsgId,
			String reportingEntityCode, String currencyCode, String resCountryCode, String sourceDoc,
			String accountingStandard, String reportingPeriod) {
		super();
		this.tieDocId = tieDocId;
		this.name = name;
		this.code = code;
		this.description = description;
		this.tieDocTypeId = tieDocTypeId;
		this.tieMsgId = tieMsgId;
		this.reportingEntityCode = reportingEntityCode;
		this.currencyCode = currencyCode;
		this.resCountryCode = resCountryCode;
		this.sourceDoc = sourceDoc;
		this.accountingStandard = accountingStandard;
		this.reportingPeriod = reportingPeriod;
	}

	public String getTable3String() {
		return table3String;
	}

	public void setTable3String(String table3String) {
		this.table3String = table3String;
	}

	public TieTaxEntity getReportingEntity() {
		return reportingEntity;
	}

	public void setReportingEntity(TieTaxEntity reportingEntity) {
		this.reportingEntity = reportingEntity;
	}

	public List<CbcrTable3> getCbcrTable3List() {
		return cbcrTable3List;
	}

	public void setCbcrTable3List(List<CbcrTable3> cbcrTable3List) {
		this.cbcrTable3List = cbcrTable3List;
	}

	public List<CbcrTable2> getCbcrTable2List() {
		return cbcrTable2List;
	}

	public void setCbcrTable2List(List<CbcrTable2> cbcrTable2List) {
		this.cbcrTable2List = cbcrTable2List;
	}

	public List<CbcrTable1> getCbcrTable1List() {
		return cbcrTable1List;
	}

	public void setCbcrTable1List(List<CbcrTable1> cbcrTable1List) {
		this.cbcrTable1List = cbcrTable1List;
	}

	public List<TieTaxEntity> getTaxEntityList() {
		return taxEntityList;
	}

	public void setTaxEntityList(List<TieTaxEntity> taxEntityList) {
		this.taxEntityList = taxEntityList;
	}

	public String getReportingPeriod() {
		return reportingPeriod;
	}

	public void setReportingPeriod(String reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public int getTieDocId() {
		return tieDocId;
	}

	public void setTieDocId(int tieDocId) {
		this.tieDocId = tieDocId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTieDocTypeId() {
		return tieDocTypeId;
	}

	public void setTieDocTypeId(int tieDocTypeId) {
		this.tieDocTypeId = tieDocTypeId;
	}

	public int getTieMsgId() {
		return tieMsgId;
	}

	public void setTieMsgId(int tieMsgId) {
		this.tieMsgId = tieMsgId;
	}

	public String getReportingEntityCode() {
		return reportingEntityCode;
	}

	public void setReportingEntityCode(String reportingEntityCode) {
		this.reportingEntityCode = reportingEntityCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getResCountryCode() {
		return resCountryCode;
	}

	public void setResCountryCode(String resCountryCode) {
		this.resCountryCode = resCountryCode;
	}

	public String getSourceDoc() {
		return sourceDoc;
	}

	public void setSourceDoc(String sourceDoc) {
		this.sourceDoc = sourceDoc;
	}

	public String getAccountingStandard() {
		return accountingStandard;
	}

	public void setAccountingStandard(String accountingStandard) {
		this.accountingStandard = accountingStandard;
	}

	@Override
	public String toString() {
		return "TieDoc [tieDocId=" + tieDocId + ", name=" + name + ", code=" + code + ", description=" + description
				+ ", tieDocTypeId=" + tieDocTypeId + ", tieMsgId=" + tieMsgId + ", reportingEntityCode="
				+ reportingEntityCode + ", currencyCode=" + currencyCode + ", resCountryCode=" + resCountryCode
				+ ", sourceDoc=" + sourceDoc + ", accountingStandard=" + accountingStandard + "]";
	}

}
