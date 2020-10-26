package com.psl.training.service;

import com.psl.training.dao.CustomerDao;
import com.psl.training.ordersystem.Customer;

public class CustomerService {
	CustomerDao cdao = new CustomerDao();
	
	public Customer getCustomer(int custid) {
		return cdao.getCustomer(custid);
	}

}
