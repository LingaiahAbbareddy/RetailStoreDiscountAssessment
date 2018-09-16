package com.assessment.RetailStoreDiscountAssessment.service;

import org.springframework.stereotype.Service;

import com.assessment.RetailStoreDiscountAssessment.exception.BillingException;
import com.assessment.RetailStoreDiscountAssessment.model.Bill;
import com.assessment.RetailStoreDiscountAssessment.model.Product;
import com.assessment.RetailStoreDiscountAssessment.model.User;

@Service
public interface BillingService {
	Bill getBillDetails(User user, Product product, double billAmount, String yearsOfRelation) throws BillingException;
}
