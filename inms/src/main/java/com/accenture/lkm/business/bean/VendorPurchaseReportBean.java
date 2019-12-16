package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class VendorPurchaseReportBean {
	@NotBlank
	private String vendorName;
	
	
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fromDate;
	
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date toDate;

	public VendorPurchaseReportBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorPurchaseReportBean(@NotBlank String vendorName, Date fromDate, Date toDate) {
		super();
		this.vendorName = vendorName;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "VendorPurchaseReportBean [vendorName=" + vendorName + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ "]";
	}
	
	
}
