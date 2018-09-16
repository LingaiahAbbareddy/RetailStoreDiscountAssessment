package com.assessment.RetailStoreDiscountAssessment.service;

import org.springframework.stereotype.Service;

import com.assessment.RetailStoreDiscountAssessment.exception.BillingException;
import com.assessment.RetailStoreDiscountAssessment.model.Bill;
import com.assessment.RetailStoreDiscountAssessment.model.Product;
import com.assessment.RetailStoreDiscountAssessment.model.User;

@Service
public class BillingServiceImpl implements BillingService {

	@Override
	public Bill getBillDetails(User user, Product product, double billAmount, String yearsOfRelation)
			throws BillingException {
		try {
			Bill bill = new Bill();
			bill.setBillAmount(billAmount);
			double discount = calculateDiscount(user, product, billAmount, bill, yearsOfRelation);
			bill.setDiscount(discount);
			bill.setTotalAmount(billAmount - discount);
			bill.setStatus("success");
			bill.setErrorMessage("");
			return bill;
		} catch (Exception e) {
			throw new BillingException("Exception when applying the discount " + e.getMessage());
		}

	}

	private double calculateDiscount(User user, Product product, double billAmount, Bill bill, String yearsOfRelation)
			throws BillingException {
		double discount = 0.0;
		StringBuilder details = new StringBuilder();
		if (!Product.GROCERRIES.equals(product)) {
			if (User.EMPLOYEE.equals(user)) {
				discount = billAmount * .3;
				details.append("30% of discount : " + discount);
			} else if (User.AFFILIATE_TO_STORE.equals(user)) {
				discount = billAmount * .1;
				details.append("10% of discount : " + discount);
			} else if (User.OTHER.equals(user) && yearsOfRelation != null && Double.valueOf(yearsOfRelation) > 2.0) {
				discount = billAmount * .05;
				details.append("5% of discount : " + discount);
			}
			details.append(" and ");
		}

		return discount + getNonPercenategDiscount(bill, details, billAmount);
	}

	private double getNonPercenategDiscount(Bill bill, StringBuilder details, double billAmount) {
		double discount = (billAmount > 100) ? (billAmount / 100) * 5 : 0.0;
		details.append(" $" + discount + " is applied");
		bill.setDiscountDetails(details.toString());
		return discount;
	}
}
