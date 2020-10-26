package com.psl.training.ordersystem;

import com.psl.training.service.CustomerService;

public class CustomerTest {

	public static void main(String[] args) {
		CustomerService cs = new CustomerService(); 
		System.out.println(cs.getCustomer(1));
	}

}
