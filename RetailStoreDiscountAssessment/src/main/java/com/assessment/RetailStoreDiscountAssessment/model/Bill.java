package com.assessment.RetailStoreDiscountAssessment.model;

public class Bill {
	private double billAmount;
	private double discount;
	private String discountDetails;
	private double totalAmount;
	private String status;
	private String errorMessage;

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDiscountDetails() {
		return discountDetails;
	}

	public void setDiscountDetails(String discountDetails) {
		this.discountDetails = discountDetails;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
