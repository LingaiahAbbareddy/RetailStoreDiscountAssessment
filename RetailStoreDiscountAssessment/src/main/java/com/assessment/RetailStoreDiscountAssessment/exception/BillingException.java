package com.assessment.RetailStoreDiscountAssessment.exception;

public class BillingException extends Exception {
	private String message;

	public BillingException() {
		super();
	}

	public BillingException(String message) {
		super();
		this.message = message;
	}

}
