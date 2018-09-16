package com.assessment.RetailStoreDiscountAssessment;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.assessment.RetailStoreDiscountAssessment.controller.BillingController;
import com.assessment.RetailStoreDiscountAssessment.model.Product;
import com.assessment.RetailStoreDiscountAssessment.model.User;
import com.assessment.RetailStoreDiscountAssessment.service.BillingService;
import com.assessment.RetailStoreDiscountAssessment.service.BillingServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RetailStoreDiscountAssessmentApplicationTests {
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Autowired
	private BillingController controller;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Configuration
	static class Config {
		@Bean
		public BillingController getBillingController() {
			return new BillingController();
		}

		@Bean
		public BillingService getBillingService() {
			return new BillingServiceImpl();
		}
	}

	@Test
	public void testEmployeeWithNonGroceries() throws Exception {
		/**
		 * User = Employee 
		 * Product = Non Groceries 
		 * Gross Bill Amount = 600.0 
		 * 30% of discount = 180.0 
		 * $ discount = 30.0
		 * Total discount = 210.0 
		 * Total payable Amount = 390.0
		 */
		mockMvc.perform(get("/bill" + "?" + "user=" + User.EMPLOYEE + "&" + "product=" + Product.NON_GROCERRIES + "&"
				+ "billAmount=" + 600.0))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("billAmount", is(600.0)))
				.andExpect(jsonPath("discount", is(210.0)))
				.andExpect(jsonPath("totalAmount", is(390.0)));
	}

	@Test
	public void testAffiliateToStoreWithNonGroceries() throws Exception {
		/**
		 * User = Employee 
		 * Product = Non Groceries 
		 * Gross Bill Amount = 600.0 
		 * 10% of discount = 60.0
		 * $ discount = 30.0 
		 * Total discount = 90.0 
		 * Total payable Amount = 510.0
		 */
		mockMvc.perform(get("/bill" + "?" + "user=" + User.AFFILIATE_TO_STORE + "&" + "product="
				+ Product.NON_GROCERRIES + "&" + "billAmount=" + 600.0))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("billAmount", is(600.0)))
				.andExpect(jsonPath("discount", is(90.0)))
				.andExpect(jsonPath("totalAmount", is(510.0)));
	}

	@Test
	public void testYearsOfRelationWithNonGroceries() throws Exception {
		/**
		 * User = Employee 
		 * Product = Non Groceries 
		 * Gross Bill Amount = 600.0 
		 * yearsOfRelation = 2
		 * 5% of discount = 30.0
		 * $ discount = 30.0 
		 * Total discount = 90.0 
		 * Total payable Amount = 540.0
		 */
		mockMvc.perform(get("/bill" + "?" + "user=" + User.OTHER + "&" + "product=" + Product.NON_GROCERRIES + "&"
				+ "billAmount=" + 600.0 + "&" + "yearsOfRelation=" + 2.6))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("billAmount", is(600.0)))
				.andExpect(jsonPath("discount", is(60.0)))
				.andExpect(jsonPath("totalAmount", is(540.0)));
	}
	
	@Test
	public void testEmployeeWithGroceries() throws Exception {
		/**
		 * User = Employee 
		 * Product = Groceries 
		 * Gross Bill Amount = 600.0 
		 * % of discount = 0.0 
		 * $ discount = 30.0
		 * Total discount = 30.0 
		 * Total payable Amount = 570.0
		 */
		mockMvc.perform(get("/bill" + "?" + "user=" + User.EMPLOYEE + "&" + "product=" + Product.GROCERRIES + "&"
				+ "billAmount=" + 600.0)).andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("billAmount", is(600.0)))
				.andExpect(jsonPath("discount", is(30.0)))
				.andExpect(jsonPath("totalAmount", is(570.0)));
	}
	
	@Test
	public void testAffiliateToStoreWithGroceries() throws Exception {
		/**
		 * User = Employee 
		 * Product = Groceries 
		 * Gross Bill Amount = 600.0 
		 * % of discount = 0.0
		 * $ discount = 30.0 
		 * Total discount = 30.0 
		 * Total payable Amount = 570.0
		 */
		mockMvc.perform(get("/bill" + "?" + "user=" + User.AFFILIATE_TO_STORE + "&" + "product="
				+ Product.GROCERRIES + "&" + "billAmount=" + 600.0))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("billAmount", is(600.0)))
				.andExpect(jsonPath("discount", is(30.0)))
				.andExpect(jsonPath("totalAmount", is(570.0)));
	}
	
	@Test
	public void testYearsOfRelationWithGroceries() throws Exception {
		/**
		 * User = Employee 
		 * Product = Groceries 
		 * Gross Bill Amount = 600.0 
		 * yearsOfRelation = 2
		 * % of discount = 0.0
		 * $ discount = 30.0 
		 * Total discount = 30.0 
		 * Total payable Amount = 570.0
		 */
		mockMvc.perform(get("/bill" + "?" + "user=" + User.OTHER + "&" + "product=" + Product.GROCERRIES + "&"
				+ "billAmount=" + 600.0 + "&" + "yearsOfRelation=" + 2.6))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("billAmount", is(600.0)))
				.andExpect(jsonPath("discount", is(30.0)))
				.andExpect(jsonPath("totalAmount", is(570.0)));
	}
	
	@Test
	public void testEmployeeYearsOfRelationWithGroceries() throws Exception {
		/**
		 * User = Employee 
		 * Product = Groceries 
		 * Gross Bill Amount = 600.0 
		 * Validation failed
		 */
		mockMvc.perform(get("/bill" + "?" + "user=" + User.EMPLOYEE + "&" + "product=" + Product.GROCERRIES + "&"
				+ "billAmount=" + 600.0 + "&" + "yearsOfRelation=" + 2.6))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("status", is("Failed")));
	}
	
	@Test
	public void testAffiliateToStoreOfRelationWithGroceries() throws Exception {
		/**
		 * User = Employee 
		 * Product = Groceries
		 * yearsOfRelation = 2
		 * Validation failed 		
		 */
		mockMvc.perform(get("/bill" + "?" + "user=" + User.AFFILIATE_TO_STORE + "&" + "product=" + Product.GROCERRIES + "&"
				+ "billAmount=" + 600.0 + "&" + "yearsOfRelation=" + 2))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("status", is("Failed")));
	}


}
