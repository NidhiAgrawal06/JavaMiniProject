package com.service;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.ordersystem.Customer;

public class CustomerService {
	Scanner sc = new Scanner(System.in);
	
	CustomerDao dao = new CustomerDao();
	
	
	public void insertCustomer(Customer c){
		dao.addcustomer(c);
	}


	public void setAddress(Customer c) {
		
		System.out.println("Enter Street:");
		String street = sc.nextLine();
		c.setStreet(street);
		
		System.out.println("Enter City:");
		String city = sc.nextLine();
		c.setCity(city);
		
		System.out.println("Enter State:");
		String state = sc.nextLine();
		c.setState(state);
		
		System.out.println("Enter Zipcode:");
		String zipcode = sc.nextLine();
		c.setZipcode(zipcode);
		
		dao.setAddress(c);
		
	}


	public void setContact(Customer c) {
		System.out.println("Enter HomePhone:");
		String homePhone = sc.nextLine();
		c.setHomePhone(homePhone);
		
		System.out.println("Enter WorkPhone:");
		String workPhone = sc.nextLine();
		c.setWorkPhone(workPhone);
		
		System.out.println("Enter Cellphone:");
		String cellPhone = sc.nextLine();
		c.setCellPhone(cellPhone);
		
		dao.setContact(c);
		
	}
	
	public Customer getCustomer(int custid) {
		return dao.getCustomer(custid);
	}


	public void setPoOrder(int id) {
			dao.setPoOrder(id);		
	}
	
	public Customer getCustomerViaPoId(int poNo) {
		int cid =dao.getCustomerDetail(poNo);
		return dao.getCustomer(cid);
		
		
		
	}

	
	

}
