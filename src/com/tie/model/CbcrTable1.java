package com.tie.model;

public class CbcrTable1 implements java.io.Serializable{
	private int tieDocId;
	private String taxJurisdiction;
	private float revenueUnrelatedParty;
	private float revenueRelatedParty;
	private float revenueTotal;
	private float plBeforeIncomeTax;
	private float incomeTaxPaid;
	private float incomeTaxAccrued;
	private float statedCapital;
	private float accumulatedEarnings;
	private int numberOfEmployees;
	private float tangibleAssetsNonCash;

	public CbcrTable1() {

	}

	public CbcrTable1(int tieDocId, String taxJurisdiction, float revenueUnrelatedParty, float revenueRelatedParty,
			float revenueTotal, float plBeforeIncomeTax, float incomeTaxPaid, float incomeTaxAccrued,
			float statedCapital, float accumulatedEarnings, int numberOfEmployees, float tangibleAssetsNonCash) {
		super();
		this.tieDocId = tieDocId;
		this.taxJurisdiction = taxJurisdiction;
		this.revenueUnrelatedParty = revenueUnrelatedParty;
		this.revenueRelatedParty = revenueRelatedParty;
		this.revenueTotal = revenueTotal;
		this.plBeforeIncomeTax = plBeforeIncomeTax;
		this.incomeTaxPaid = incomeTaxPaid;
		this.incomeTaxAccrued = incomeTaxAccrued;
		this.statedCapital = statedCapital;
		this.accumulatedEarnings = accumulatedEarnings;
		this.numberOfEmployees = numberOfEmployees;
		this.tangibleAssetsNonCash = tangibleAssetsNonCash;
	}

	public int getTieDocId() {
		return tieDocId;
	}

	public void setTieDocId(int tieDocId) {
		this.tieDocId = tieDocId;
	}

	public String getTaxJurisdiction() {
		return taxJurisdiction;
	}

	public void setTaxJurisdiction(String taxJurisdiction) {
		this.taxJurisdiction = taxJurisdiction;
	}

	public float getRevenueUnrelatedParty() {
		return revenueUnrelatedParty;
	}

	public void setRevenueUnrelatedParty(float revenueUnrelatedParty) {
		this.revenueUnrelatedParty = revenueUnrelatedParty;
	}

	public float getRevenueRelatedParty() {
		return revenueRelatedParty;
	}

	public void setRevenueRelatedParty(float revenueRelatedParty) {
		this.revenueRelatedParty = revenueRelatedParty;
	}

	public float getRevenueTotal() {
		return revenueTotal;
	}

	public void setRevenueTotal(float revenueTotal) {
		this.revenueTotal = revenueTotal;
	}

	public float getPlBeforeIncomeTax() {
		return plBeforeIncomeTax;
	}

	public void setPlBeforeIncomeTax(float plBeforeIncomeTax) {
		this.plBeforeIncomeTax = plBeforeIncomeTax;
	}

	public float getIncomeTaxPaid() {
		return incomeTaxPaid;
	}

	public void setIncomeTaxPaid(float incomeTaxPaid) {
		this.incomeTaxPaid = incomeTaxPaid;
	}

	public float getIncomeTaxAccrued() {
		return incomeTaxAccrued;
	}

	public void setIncomeTaxAccrued(float incomeTaxAccrued) {
		this.incomeTaxAccrued = incomeTaxAccrued;
	}

	public float getStatedCapital() {
		return statedCapital;
	}

	public void setStatedCapital(float statedCapital) {
		this.statedCapital = statedCapital;
	}

	public float getAccumulatedEarnings() {
		return accumulatedEarnings;
	}

	public void setAccumulatedEarnings(float accumulatedEarnings) {
		this.accumulatedEarnings = accumulatedEarnings;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public float getTangibleAssetsNonCash() {
		return tangibleAssetsNonCash;
	}

	public void setTangibleAssetsNonCash(float tangibleAssetsNonCash) {
		this.tangibleAssetsNonCash = tangibleAssetsNonCash;
	}

	@Override
	public String toString() {
		return "CbcrTable1 [tieDocId=" + tieDocId + ", taxJurisdiction=" + taxJurisdiction + ", revenueUnrelatedParty="
				+ revenueUnrelatedParty + ", revenueRelatedParty=" + revenueRelatedParty + ", revenueTotal="
				+ revenueTotal + ", plBeforeIncomeTax=" + plBeforeIncomeTax + ", incomeTaxPaid=" + incomeTaxPaid
				+ ", incomeTaxAccrued=" + incomeTaxAccrued + ", statedCapital=" + statedCapital
				+ ", accumulatedEarnings=" + accumulatedEarnings + ", numberOfEmployees=" + numberOfEmployees
				+ ", tangibleAssetsNonCash=" + tangibleAssetsNonCash + "]";
	}

}
