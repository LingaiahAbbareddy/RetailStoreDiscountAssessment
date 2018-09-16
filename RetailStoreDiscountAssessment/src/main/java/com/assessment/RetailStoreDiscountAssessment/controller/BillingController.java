package com.assessment.RetailStoreDiscountAssessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.RetailStoreDiscountAssessment.exception.BillingException;
import com.assessment.RetailStoreDiscountAssessment.model.Bill;
import com.assessment.RetailStoreDiscountAssessment.model.Product;
import com.assessment.RetailStoreDiscountAssessment.model.User;
import com.assessment.RetailStoreDiscountAssessment.service.BillingService;

@RestController
public class BillingController {
	@Autowired
	BillingService service;

	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public Bill getBillingDetails(@RequestParam User user, @RequestParam Product product,
			@RequestParam double billAmount, @RequestParam(required = false) String yearsOfRelation)
			throws BillingException {
		if (!User.OTHER.equals(user) && yearsOfRelation != null) {
			Bill response = new Bill();
			response.setStatus("Failed");
			response.setDiscountDetails("");
			response.setErrorMessage("yearsOfRelation will not applicable to Employee or Affiliated to store,"
					+ " Please select the user as OTHER");
			return response;
		}

		return service.getBillDetails(user, product, billAmount, yearsOfRelation);
	}
}
