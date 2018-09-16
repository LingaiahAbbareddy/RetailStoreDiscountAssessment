# RetailStoreDiscountAssessment
Project for Retail Store Billing to apply the discount.
It is having below use cases
	1. If the user is an employee of the store,	he gets	a 30%	discount
	2. If the user is an affiliate of the store, he	gets a 10%	discount
	3. If the user has	been a customer	for	over 2 years, he gets a	5% discount.
	4. For every $100 on the bill, there would be a	$5 discount (e.g. for $990, you	get	$45	
	as a discount).
	5. The percentage	based	discounts	do	not	apply	on	groceries.
	6. A user can get only one of the percentage based	discounts on a bill
	
Contents of Project :

=> This project is implemented in object oriented fashion and with the latest technologies Spring boot
Created a rest service "getBill", it will take the inputs like User type, product type and total bill amount and years of relation 
and it will calculate the discount and apply to the total bill amount and return the total payable amount.

(1) Controller
(2)Service Class
(3)Junit test case
(4)Code coverage
(5)Class diagram

Steps to run the project
-----------------
Project setup 

1. Clone or Download project from github repository .

2. import in eclipse (File -> import ->Existing Maven Project -> Root Directory -> Finish)

3. Right click on project -> Maven-> update project

4. Right click on project -> Run as -> Maven clean

5. Right click on project -> Run as -> Maven Insatll

6. Right click on RetailStoreDiscountAssessmentApplication.java -> Run As Java Application

Once the server is started run below link in browser

http://localhost:8080/RetailStoreDiscountAssessment/swagger-ui.html#!

7. Click on billing-controller -> Click on /bill

8. Enter appropriate inputs for "user", "product", "billAmount" and "yearsOfRelation" and click "Try it out"

9. The response will be displayed and could see the discount and total Amount details.


Steps to get the code coverage
------------------------------
1. Right click on RetailStoreDiscountAssessmentApplicationTests.java and click on Coverage As -> Java Application 

Out of scope:
DAO and DTO since DB is not using

Code coverage:
93.4%

