package com.parlour.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "product_type")
	private String  productType;
	
	@Column(name = "product_company")
	private String  productCompany;
	
	@Column(name = "discount")
	private Integer percentageDiscount;
	
	@Column(name = "printed_price")
	private double printedPrice;
	
	@Column(name = "product_used_for")
	private String productUsedFor;
	
	@Column(name="mfg_country")
	String mfgCountry;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(Integer productId, String productType, String productCompany, Integer percentageDiscount,
			double printedPrice, String productUsedFor, String mfgCountry) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productCompany = productCompany;
		this.percentageDiscount = percentageDiscount;
		this.printedPrice = printedPrice;
		this.productUsedFor = productUsedFor;
		this.mfgCountry = mfgCountry;
	}
	
	
	public String getProductUsedFor() {
		return productUsedFor;
	}
	public void setProductUsedFor(String productUsedFor) {
		this.productUsedFor = productUsedFor;
	}
	public String getMfgCountry() {
		return mfgCountry;
	}
	public void setMfgCountry(String mfgCountry) {
		this.mfgCountry = mfgCountry;
	}
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductCompany() {
		return productCompany;
	}
	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}
	public Integer getPercentageDiscount() {
		return percentageDiscount;
	}
	public void setPercentageDiscount(Integer percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
	public double getPrintedPrice() {
		return printedPrice;
	}
	public void setPrintedPrice(double printedPrice) {
		this.printedPrice = printedPrice;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productType=" + productType + ", productCompany=" + productCompany
				+ ", percentageDiscount=" + percentageDiscount + ", printedPrice=" + printedPrice + ", productUsedFor="
				+ productUsedFor + ", mfgCountry=" + mfgCountry + "]";
	}
	
 }
