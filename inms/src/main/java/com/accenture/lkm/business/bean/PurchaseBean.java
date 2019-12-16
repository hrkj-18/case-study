package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.web.client.MaterialTypeConsumer;

public class PurchaseBean {

		private int purchaseId;

		private String transactionId;
				
		@NotBlank
		private String vendorName;
		
		@NotBlank
		private String materialCategoryId;
		
		@NotBlank
		private String materialTypeId;
		
		@NotBlank
		private String brandName;
		
		@NotBlank
		private String unitId;
		
		@NotNull
		private Integer quantity;
		
		@NotNull
		@NumberFormat
		private Double purchaseAmount;
		
		@NotNull

		@DateTimeFormat(pattern="dd-MM-yyyy")
		private Date purchaseDate;
		
		private String materialCategoryName;
		private String materialTypeName;
		private String unitName;
		
		
		public PurchaseBean() {
		}

		public PurchaseBean(int purchaseId, String transactionId, @NotBlank String vendorName,
				@NotBlank String materialCategoryId, @NotBlank String materialTypeId, @NotBlank String brandName,
				@NotBlank String unitId, @NotNull Integer quantity, @NotNull Double purchaseAmount,
				@NotNull Date purchaseDate, String materialCategoryName, String materialTypeName, String unitName) {
			super();
			this.purchaseId = purchaseId;
			this.transactionId = transactionId;
			this.vendorName = vendorName;
			this.materialCategoryId = materialCategoryId;
			this.materialTypeId = materialTypeId;
			this.brandName = brandName;
			this.unitId = unitId;
			this.quantity = quantity;
			this.purchaseAmount = purchaseAmount;
			this.purchaseDate = purchaseDate;
			this.materialCategoryName = materialCategoryName;
			this.materialTypeName = materialTypeName;
			this.unitName = unitName;
		}



		public int getPurchaseId() {
			return purchaseId;
		}



		public void setPurchaseId(int purchaseId) {
			this.purchaseId = purchaseId;
		}



		public String getTransactionId() {
			return transactionId;
		}



		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}



		public String getVendorName() {
			return vendorName;
		}



		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}



		public String getMaterialCategoryId() {
			return materialCategoryId;
		}



		public void setMaterialCategoryId(String materialCategoryId) {
			this.materialCategoryId = materialCategoryId;
		}



		public String getMaterialTypeId() {
			return materialTypeId;
		}



		public void setMaterialTypeId(String materialTypeId) {
			this.materialTypeId = materialTypeId;
		}



		public String getBrandName() {
			return brandName;
		}



		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}



		public String getUnitId() {
			return unitId;
		}



		public void setUnitId(String unitId) {
			this.unitId = unitId;
		}



		public Integer getQuantity() {
			return quantity;
		}



		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}



		public Double getPurchaseAmount() {
			return purchaseAmount;
		}



		public void setPurchaseAmount(Double purchaseAmount) {
			this.purchaseAmount = purchaseAmount;
		}



		public Date getPurchaseDate() {
			return purchaseDate;
		}



		public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
		}



		public String getMaterialCategoryName() {
			return materialCategoryName;
		}



		public void setMaterialCategoryName(String materialCategoryName) {
			this.materialCategoryName = materialCategoryName;
		}



		public String getMaterialTypeName() {
			return materialTypeName;
		}



		public void setMaterialTypeName(String materialTypeName) {
					
			
			this.materialTypeName = materialTypeName;
		}



		public String getUnitName() {
			return unitName;
		}



		public void setUnitName(String unitName) {
			this.unitName = unitName;
		}



		@Override
		public String toString() {
			return "PurchaseBean [purchaseId=" + purchaseId + ", transactionId=" + transactionId + ", vendorName="
					+ vendorName + ", materialCategoryId=" + materialCategoryId + ", materialTypeId=" + materialTypeId
					+ ", brandName=" + brandName + ", unitId=" + unitId + ", quantity=" + quantity + ", purchaseAmount="
					+ purchaseAmount + ", purchaseDate=" + purchaseDate + ", materialCategoryName="
					+ materialCategoryName + ", materialTypeName=" + materialTypeName + ", unitName=" + unitName + "]";
		}
		
		
				
	
}
