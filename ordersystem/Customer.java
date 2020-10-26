/*Problem Statement:

 * We want to develop a Order Management system.  You have been assigned to work on
part of the system and you will be developing the Customer class.  
 The Customer class has the attributes - id, name, homePhone, cellPhone,
workPhone, street, city, state, zip.
 Create a constructor to create Customer class and it will get the parameters id and
name.
 It should have methods to printPhoneNumbers &amp; printShippingAddress.
 It should have setPrintingAddress method to change the address.  street, city, state
and zip is provided as parameters
 setPhoneNumbers to set the phone numbers.  All 3 phone numbers are provided as
parameters
 Provide a method to print all the values of fields in customer object
Develop another class called CustomerTest.  This class should create 3 Customers and call
each of the Customer methods.
 */

package com.psl.training.ordersystem;

public class Customer {
	
	private int customerNumber;
	private String name;
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private String street;
	private String state;
	private String city;
	private String zipcode;
	private int purchaseOrder;
	
	public Customer() {
		
	}
	public Customer(int id , String name,String homePhone,String cellPhone,String workPhone,String street,String state,String city,String zipcode,int purchaseOrder) 
	{
		super();
		this.customerNumber = id;
		this.name = name;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.street = street;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.purchaseOrder = purchaseOrder;
	}
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public int getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(int purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
//
//	void printPhoneNumber()
//	{
//		 System.out.println("--------Phone Details-------");
//		 System.out.println("Home Phone: "+homePhone +"\nCell Phone: "+cellPhone+"\nWork Phone: "+workPhone);
//	}
//	void pringShippingAddress()
//	{
//		System.out.println("--------Shipping Details-------");
//		System.out.println("Street: "+street+",\nCity: "+city+",\nState: "+state+",\nZip Code: "+zipcode);
//	}
//	void setPrintingAddress(String street,String city,String state ,String zipcode)
//	{
//		this.street = street;
//		this.city = city;
//		this.state = state;
//		this.zipcode = zipcode;
//	}
//	void setPhoneNumber(String homePhone,String cellPhone ,String workPhone)
//	{
//		this.homePhone = homePhone;
//		this.workPhone = workPhone;
//		this.cellPhone = cellPhone;
//	}
	void print()
	{
		System.out.println("Customer Details-----------------------------------------");
		System.out.println("Customer Id :"+customerNumber);
		System.out.println("Name :"+name);
		System.out.println("-----Contact No------");
		System.out.println("Home Phone: "+homePhone +"\nCell Phone: "+cellPhone+"\nWork Phone: "+workPhone);
		System.out.println("-----Address-----");
		System.out.println("Street: "+street+",\nCity: "+city+",\nState: "+state+",\nZip Code: "+zipcode);

	}

	public String toString() {
		return "Customer Id :" +customerNumber + ", CustomerName :" +name
				+ ", Home Phone :" +homePhone + ", Cell Phone :" + cellPhone + ", Work Phone :"
				+ workPhone + ", Street :" +street +", City :" +city +", State :" +state +", Zip Code :" + zipcode +", Purchase Order :" +purchaseOrder ;
	}
}
